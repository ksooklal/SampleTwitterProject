package TwitterAccounts;

import nba.NBAAllStarTwitterVotingUtility;
import Twitter4J.Twitter4JUtility;

public class KSOOonYFinanceTwitterAccount{
	private static final String TWITTER_HANDLE = "KSOOonYFinance";
	
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