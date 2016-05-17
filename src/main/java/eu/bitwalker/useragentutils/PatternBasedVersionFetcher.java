package eu.bitwalker.useragentutils;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extracts version from provided UserAgent string using pattern.  
 * @author alexr
 */
class PatternBasedVersionFetcher implements VersionFetcher {
	private final Pattern pattern;

	PatternBasedVersionFetcher(String regex) {
		this(Pattern.compile(regex, CASE_INSENSITIVE));
	}
	
	PatternBasedVersionFetcher(Pattern pattern) {
		this.pattern = pattern;
	}

	@Override
	public final Version version(String userAgentString) {
		Matcher matcher = pattern.matcher(userAgentString);
		if (!matcher.find()) {
			return null;
		}
		return createVersion(matcher);
	}
	
	protected Version createVersion(Matcher matcher) {
		String fullVersionString = matcher.group(1);
		String majorVersion = matcher.group(2);
		String minorVersion = "0";
		if (matcher.groupCount() > 2) // usually but not always there is a minor version
			minorVersion = matcher.group(3);
		return new Version (fullVersionString,majorVersion,minorVersion);
	}

}
