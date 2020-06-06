package com.cxl.io3;

import com.cxl.io3.say.Amplifier;
import com.cxl.io3.say.Person;

public class DecorateTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();

		Amplifier am = new Amplifier(p);
		am.say();
	}
}

interface say {
	void say();

	class Person implements say {
		private int voice = 10;

		@Override
		public void say() {
			System.out.println("人得声音为" + voice);
		}

		public int getVoice() {
			return voice;
		}

		public void setVoice(int voice) {
			this.voice = voice;
		}
	}

	class Amplifier implements say {
		private Person p;

		public Amplifier(Person p) {
			this.p = p;
		}

		@Override
		public void say() {
			System.out.println("人得声音为" + p.getVoice() * 100);
			System.out.println("噪音");
		}

	}
}