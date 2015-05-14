package com.westharrison.enums;

public enum BrowserTypes {

		FIREFOX("firefox"),
		CHROME("chrome"),
		SAFARI("safari");
		
		private final String browserName;

		private BrowserTypes(String browserName) {
			this.browserName = browserName;
		}

		public String getBrowserName() {
			return browserName;
		}
}
