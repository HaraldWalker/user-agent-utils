package eu.bitwalker.useragentutils.browser;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import eu.bitwalker.useragentutils.Version;

/**
 * There are 2 types of user agent strings that present Safari: one that contains fragment {@code Version/1.2.3} from where the version of
 * Safari browser can be extracted and others that do not. 
 * Fortunately Safari User-Agent string contains version of WebKit that can be used to discover the version of Safari browser. 
 * This class contains mapping between version of WebKit and Safari browser taken from  {@link <a href="https://en.wikipedia.org/wiki/Safari_version_history">Wikipedia</a>}  
 * In most cases version of WebKit exists and uniquely identifies version of Safari browser. 
 * Unfortunately there are several exceptions. 
 * <ol>
 * 	<li>There is no information about WebKit version for some Safari versions. This requires additional discovery</li>
 * 	<li>
 * The same version of WebKit used in several versions of Safari that causes ambiguity. Fortunately in all found cases these different versions of Safari
 * are built for different operating systems, so theoretically we can distinguish between different versions of Safari with the same web kit by using 
 * information about operating system. Such feature however is not supported by the environment right now. 
 * </li>
 * </ol>
 * @author alexr
 */
// https://en.wikipedia.org/wiki/Safari_version_history
public class SafariUtils {
	private static final String[][] webKitToSafariVersion = new String[][] {
		{"48", "0.8"},
		{"73", "0.9"},
		{"85", "1.0"},
		{"85.8.5", "1.0.3"},
		{"100", "1.1"},
		{"125", "1.2"},
		{"312", "1.3"},
		{"312.3", "1.3.1"},
		{"312.5", "1.3.2"},
		{"312.6", "1.3.2"},
		{"412", "2.0"},
		{"416.11", "2.0.2"},
		{"419.3", "2.0.4"},
		{"522.11", "3.0"},
		{"522.12", "3.0.2"},
		{"522.12.1", "3.0.3"},
		{"523.10", "3.0.4"},
		{"525.20", "3.1.1"},
		{"525.21", "3.1.2"},
		{"525.26", "3.2"},
		{"525.27", "3.2.1"},
		{"525.28", "3.2.3"},
		// {"530.17", "4.0.1"}, // ambiguity: Safari 4.0 for Mac 10.4-10.5 and Safari 4.0.1 for Windows vista and XP 
		{"530.18", "4.0.1"},
		{"530.19", "4.0.2"},
		{"531.9", "4.0.3"},
		{"531.21.10", "4.0.4"},
		{"531.22.7", "4.0.5"},
		
		// {"533.16", "4.1"}, // ambiguity: Safari 4.1  on MacOsX 10.4, Safari 5.0 on MacOsX 10.5-10.6 and Windows XP, Vista and 7  
		// {"533.17.8", "4.1.1"}, // ambiguity: Safari 4.1.1  on MacOsX 10.4, Safari 5.0.1 on MacOsX 10.5-10.6 and Windows XP, Vista and 7
		//{"533.18.5", "4.1.2"}, // ambiguity: Safari 4.1.2  on MacOsX 10.4, Safari 5.0.2 on MacOsX 10.5-10.6 and Windows XP, Vista and 7
		//{"533.19.4", "4.1.3"},// ambiguity: Safari 4.1.3  on MacOsX 10.4, Safari 5.0.3 on MacOsX 10.5-10.6 and Windows XP, Vista and 7
		
		{"533.20.27", "5.0.4"},
		{"533.21.1", "5.0.5"},
		{"533.22.3", "5.0.6"},
		{"534.48.3", "5.1"},
		{"534.51.22", "5.1.1"},
		{"534.52.7", "5.1.2"},
		{"534.53.10", "5.1.3"},
		{"534.54.16", "5.1.4"},
		{"534.55.3", "5.1.5"},
		{"534.56.5", "5.1.6"},
		{"534.57.2", "5.1.7"},
		{"534.58.2", "5.1.8"},
		{"534.59.8", "5.1.9"},
		{"534.59.10", "5.1.10"},
		{"536.25", "6.0"},
		{"536.26", "6.0.1"},
		{"536.26.17", "6.0.2"},
		{"536.28.10", "6.0.3"},
		{"536.29.13", "6.0.4"},
		{"536.30.1", "6.0.5"},
		{"537.43.58", "6.1"},
		//{"537.73.11", "6.1.1"}, // ambiguity: Safari 6.1.1 on OsX 10.7-10.8 and 7.0.1 on OsX 10.9
		
		
		// data is absent in wikipedia
//		{"", "6.1.2"},
//		{"", "6.1.3"},
//		{"", "6.1.4"},
//		{"", "6.1.5"},
		// {"537.78.2", "6.1.6"}, // ambiguity: Safari 6.1.6 on OsX 10.7-10.8 and 7.0.6 on OsX 10.9
		// data is absent in wikipedia
//		{"", "6.2"},
//		{"", "6.2.1"},
//		{"", "6.2.2"},
//		{"", "6.2.3"},
//		{"", "6.2.4"},
//		{"", "6.2.5"},
//		{"", "6.2.6"},
//		{"", "6.2.7"},
		
		
		// {"537.85.17", "6.2.8"}, // ambiguity: Safari 6.2.8 on OsX 10.8 and 7.1.8 on OsX 10.9 
		
		{"537.71", "7.0"},
		// data is absent in wikipedia
//		{"", "7.0.2"},
		{"537.75.14", "7.0.3"},
		{"537.76.4", "7.0.4"},
		{"537.77.4", "7.0.5"},
		
		////{"537.78.2", "7.0.6"}, //TODO ambiguity
		
		// data is absent in wikipedia
//		{"", "7.1"},
//		{"", "7.1.1"},
//		{"", "7.1.2"},
//		{"", "7.1.3"},
//		{"", "7.1.4"},
//		{"", "7.1.5"},
//		{"", "7.1.6"},
//		{"", "7.1.7"},
		{"538.35.8", "8.0"},

		// data is absent in wikipedia
//		{"", "8.0.1"},
//		{"", "8.0.2"},
//		{"", "8.0.3"},
//		{"", "8.0.4"},
//		{"", "8.0.5"},
		
		{"600.6.3", "8.0.6"},
		{"600.7.12", "8.0.7"},
		// data is absent in wikipedia
//		{"", "8.0.8"},
//		{"", "9.0"},
		
		{"601.2.7", "9.0.1"},
		{"601.3.9", "9.0.2"},
		{"601.4.4", "9.0.3"},
		{"601.5.17", "9.1"},
		{"522.11.3", "3.0"},
		{"522.13.1", "3.0.2"},
		{"522.12.2", "3.0.1"},
		{"522.15.5", "3.0.3"},
		{"523.12.9", "3.0.4"},
		{"523.13", "3.0.4"},
		{"523.15", "3.0.4"},
		// mac os 10.4 - 10.5 and Windows XP, Vista
		{"525.13", "3.1"},  
		{"525.17", "3.1.1"}, 
		{"525.21", "3.1.2"},
		
		{"525.26.13", "3.2"},
		{"525.27.1", "3.2.1"},
		{"525.28.1", "3.2.2"},
		{"525.29.1", "3.2.3"},
		
		{"526.12.2", "4.0"},
		{"528.1.1", "4.0"},

		{"526.11.2", "4.0"}, // actually 4.0 beta
		// 4.0 and 4.0 beta but since it is the same version we do not distinguish between 4.0 and 4.0 beta
		{"528.16", "4.0"}, 
		{"528.17", "4.0"},
		// end of 4.0 and 4.0 beta
		
		{"530.19.1", "4.0.2"},
		{"531.9.1", "4.0.3"},
		{"531.22.7", "4.0.5"},
		{"534.50", "5.1"},
	};
	private static final Map<String, Version> safariVersions;
	
	static {
		Map<String, Version> versions = new HashMap<String, Version>();
		for (String[] pair : webKitToSafariVersion) {
			String webKitVersion = pair[0];
			String browserVersion = pair[1];
			String[] parts = browserVersion.split("\\.");
			String majorVersion = parts[0]; 
			String minorVersion = parts.length > 1 ? parts[1] : null; 
			Version version = new Version(browserVersion, majorVersion, minorVersion);
			versions.put(webKitVersion, version);
		}
		safariVersions = Collections.unmodifiableMap(versions);
	}

	public static Map<String, Version> getWebKitToSafariVersion() {
		return safariVersions;
	}
}
