package com.westharrison.enums;

public enum BrowserTypes {

		firefox("firefox"),
		chrome("chrome"),
		safari("safari");
		
		private String browserName;

		private BrowserTypes(String browserName) {
			this.browserName = browserName;
		}

		public String getBrowserName() {
			return browserName;
		}
		
		
}
