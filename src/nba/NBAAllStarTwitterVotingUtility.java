package nba;

import java.util.ArrayList;

import Twitter4J.Twitter4JUtility;

public final class NBAAllStarTwitterVotingUtility {	
	public static final String [] EASTERN_CONFERENCE_PLAYERS = new String [] 
			{"John Wall", "Bradley Beal", "Marcin Gortat", "Otto Porter", "Markieff Morris", "Kelly Oubre",
			 "Jason Smith", "Tomas Satoransky", "Jodie Meeks"};
	public static final String [] WESTERN_CONFERENCE_PLAYERS = new String []
			{"Trevor Ariza"};
	public static final String HASH_TAG = " #NBAVote";
	
	public static ArrayList<String> get2017EasternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<String>();
		for (String player: EASTERN_CONFERENCE_PLAYERS){
			tweets.add(player + HASH_TAG);
		}
		return tweets;
	}
	
	public static ArrayList<String> get2017WesternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<String>();
		for (String player: WESTERN_CONFERENCE_PLAYERS){
			tweets.add(player + HASH_TAG);
		}
		return tweets;
	}
	
	public static ArrayList<String> get2017NBATweets(){
		ArrayList<String> easternTweets = get2017EasternConferenceTweets();
		easternTweets.addAll(get2017WesternConferenceTweets());
		return easternTweets;
	}
	
	public static void sendNBATweets(String twitterHandle) {
		for (String tweet: get2017NBATweets()){
			Twitter4JUtility.publishTweet(tweet, twitterHandle);
		}
	}
}
