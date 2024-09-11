// Builder Pattern : URL Builder Application

public class BuilderPattern{

	// Product Class Representing the URL with various components
	public static class URL{

		// Nested Builder Class for constructing the URL object
		public static class URLBuilder{
			private String protocol;
			private String domainName;
			private String topLevelDomain;
			private String port;
			private String path;

            // Method to build and return the constructed URL object
			public URL Build(){
				return new URL(this);
			}

            // Builder methods to set each component of the URL
			public URLBuilder setProtocol(String protocol){
				this.protocol = protocol;
				return this;
			}

			public URLBuilder setDomainName(String domain){
				this.domainName = domain;
				return this;
			}

			public URLBuilder setTopLevelDomain(String tld){
				this.topLevelDomain = tld;
				return this;
			}

			public URLBuilder setPort(String port){
				this.port = port;
				return this;
			}

			public URLBuilder setPath(String path){
				this.path = path;
				return this;
			}
		}

        // Final fields for the URL components (constructed via the builder)
		public final String protocol;
		public final String domainName;
		public final String topLevelDomain;
		public final String port;
		public final String path;

		private URL(URLBuilder builder){
			this.protocol = builder.protocol;
			this.domainName = builder.domainName;
			this.topLevelDomain = builder.topLevelDomain;
			this.port = builder.port;
			this.path = builder.path;
		}
	}

    // Client Code for testing the URL Builder
	public static void main(String[] args){

		URL.URLBuilder builder = new URL.URLBuilder();
		builder.setProtocol("https")
			.setDomainName("ei")
			.setTopLevelDomain("study")
			.setPath("careers");

		URL url = builder.Build();

		// https://ei.study/careers
		System.out.println(url.protocol + "://" + url.domainName + "."
			+ url.topLevelDomain + "/" + url.path);

		URL.URLBuilder builder2 = new URL.URLBuilder();
		builder2.setProtocol("http")
			.setDomainName("example")
			.setTopLevelDomain("com")
			.setPort("80")
			.setPath("example1");

		URL url2 = builder2.Build();

		// https://example.com:80/example1
		System.out.println(url2.protocol + "://" + url2.domainName + "."
			+ url2.topLevelDomain + ":" + url2.port + "/" + url2.path);

	}
}

// The URL class store the final value of a URL and once the URL is built
// it will become immutable (similar to StringBuilder) due to final keyword