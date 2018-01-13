package nba;

import java.util.ArrayList;
import Twitter4J.Twitter4JUtility;

public final class NBAAllStarTwitterVotingUtility {	
	private static final String [] EASTERN_CONFERENCE_PLAYERS = new String []
			{"John Wall", "Bradley Beal", "Marcin Gortat", "Otto Porter", "Markieff Morris", "Kelly Oubre",
			 "Jason Smith", "Tomas Satoransky"};
	private static final String [] WESTERN_CONFERENCE_PLAYERS = new String []
			{"Trevor Ariza", "Jared Dudley"};
	private static final String HASH_TAG_2018 = " #NBAVote";
	
	private static ArrayList<String> get2018EasternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<>();
		for (String player: EASTERN_CONFERENCE_PLAYERS){
			tweets.add(player + HASH_TAG_2018);
		}
		return tweets;
	}
	
	private static ArrayList<String> get2018WesternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<>();
		for (String player: WESTERN_CONFERENCE_PLAYERS){
			tweets.add(player + HASH_TAG_2018);
		}
		return tweets;
	}
	
	public static ArrayList<String> get2018NBATweets(){
		ArrayList<String> easternTweets = get2018EasternConferenceTweets();
		easternTweets.addAll(get2018WesternConferenceTweets());
		return easternTweets;
	}
	
	public static void sendNBATweets(String twitterHandle) {
		for (String tweet: get2018NBATweets()){
			Twitter4JUtility.publishTweet(tweet, twitterHandle);
		}
	}
}