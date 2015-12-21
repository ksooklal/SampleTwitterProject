package TwitterAccounts;

import NBA.NBAAllStarTwitterVotingUtility;
import Twitter4J.Twitter4JUtility;

public class WizardsBestFanTwitterAccount{
	public static final String TWITTER_HANDLE = "wizardsbestfan";
	
	public static String getTwitterHandle() {
		return TWITTER_HANDLE;
	}
	
	public static void sendNBATweets(){
		NBAAllStarTwitterVotingUtility.sendNBATweets(TWITTER_HANDLE);
	}
	
	public static void sendTweet(String tweet){
		Twitter4JUtility.publishTweet(tweet, TWITTER_HANDLE);
	}
}
