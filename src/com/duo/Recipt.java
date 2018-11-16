package com.duo;

import java.text.MessageFormat;

public class Recipt {
	private static String formatInt(int amount) {
	    return new MessageFormat("{0,number}").format(new Object[]{amount});
	}

	private static String formatAmount(int amount) {
	    return new MessageFormat("{0,number,currency}").format(new Object[]{amount})
	        .replace(' ', '\u00a0');
	}

}
