package Twitter4J;

import java.io.BufferedReader;
import java.io.FileReader;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Twitter4JUtility {
	private static final String CONFIG_FILE_PATH = "resources/api.config";

	public static void main (String [] args){
		System.out.println(getConsumerKey("kristiansooklal"));
		System.out.println(getConsumerSecret("kristiansooklal"));
		System.out.println(getAccessToken("kristiansooklal"));
		System.out.println(getAccessTokenSecret("kristiansooklal"));

		System.out.println(getConsumerKey("wizardsbestfan"));
		System.out.println(getConsumerSecret("wizardsbestfan"));
		System.out.println(getAccessToken("wizardsbestfan"));
		System.out.println(getAccessTokenSecret("wizardsbestfan"));

		System.out.println(getConsumerKey("KSOOonYFinance"));
		System.out.println(getConsumerSecret("KSOOonYFinance"));
		System.out.println(getAccessToken("KSOOonYFinance"));
		System.out.println(getAccessTokenSecret("KSOOonYFinance"));
	}
	
	public static boolean publishTweet(String tweet, String twitterHandle){
		try {
			final String consumerKey = getConsumerKey(twitterHandle);
			final String consumerSecret = getConsumerSecret(twitterHandle);
			final String accessToken = getAccessToken(twitterHandle);
			final String accessTokenSecret = getAccessTokenSecret(twitterHandle);
			
			if (consumerKey == null || consumerSecret == null || accessToken == null || accessTokenSecret == null){
				return false;
			}
			
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			
			AccessToken accessTokenObject = new AccessToken(accessToken, accessTokenSecret);
			
			twitter.setOAuthAccessToken(accessTokenObject);
			twitter.updateStatus(tweet);

			return true;
		} catch (TwitterException te) {
			te.printStackTrace();
			return false;
		}
	}

	private static final String [] getAllKeys(String twitterHandle){
		String line = null;
		String [] apiKeys = new String [4];
		
		if (twitterHandle != null){
			try {
				FileReader fileReader = new FileReader(CONFIG_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				boolean twitterAccountFound = false;
				
				int currentApiKeyIndex = 0;
				
				while((line = bufferedReader.readLine()) != null) {
					if (twitterAccountFound){
						if (currentApiKeyIndex == 4){
							return apiKeys;
						} else {
							apiKeys[currentApiKeyIndex++] = (line == null) ? line : line.trim();
						}
					}
					if (line != null && line.toUpperCase().trim().equalsIgnoreCase(twitterHandle.trim() + ":")){
						twitterAccountFound = true;
					}
				}
			} catch (Exception e){
				return apiKeys;
			}
		}
		return apiKeys;
	}
	
	public static String getConsumerKey(String twitterHandle){
		return getAllKeys(twitterHandle)[0];
	}
	
	public static String getConsumerSecret(String twitterHandle){
		return getAllKeys(twitterHandle)[1];
	}
	
	public static String getAccessToken(String twitterHandle){
		return getAllKeys(twitterHandle)[2];
	}
	
	public static String getAccessTokenSecret(String twitterHandle){
		return getAllKeys(twitterHandle)[3];
	}
}