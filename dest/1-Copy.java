ter(dest))) {

			// 3操作（分段读取）
			String lene = null;
			while ((lene = br.readLine()) != null) {
				wr.write(lene);
				wr.newLine();
			}
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放资源 分别关闭 先打开得后关闭
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				if (null != is) {
					is.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public static void copy2(String srcPath, String destPath) {
		// 1创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2选择流

		try (InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest);) {

			// 3操作（分段读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收�