��度
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);// 分段读取
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
