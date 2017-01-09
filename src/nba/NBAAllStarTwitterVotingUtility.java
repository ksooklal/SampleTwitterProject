package nba;

import java.util.ArrayList;

import Twitter4J.Twitter4JUtility;

public final class NBAAllStarTwitterVotingUtility {	
	public static final String [] EASTERN_CONFERENCE_PLAYERS = new String [] 
			{"John Wall", "Bradley Beal", "Marcin Gortat", "Otto Porter", "Markieff Morris",
					"Trey Burke", "Jason Smith", "Tomas Satoransky"};
	public static final String [] WESTERN_CONFERENCE_PLAYERS = new String []
			{"Trevor Ariza", "Zaza Pachulia"};
	
	public static ArrayList<String> get2016EasternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<String>();
		for (String player: EASTERN_CONFERENCE_PLAYERS){
			tweets.add(player + " #NBAVote");
		}
		return tweets;
	}
	
	public static ArrayList<String> get2016WesternConferenceTweets(){
		ArrayList<String> tweets = new ArrayList<String>();
		for (String player: WESTERN_CONFERENCE_PLAYERS){
			tweets.add(player + " #NBAVote");
		}
		return tweets;
	}
	
	public static ArrayList<String> getNBATweets(){
		ArrayList<String> easternTweets = get2016EasternConferenceTweets();
		easternTweets.addAll(get2016WesternConferenceTweets());
		return easternTweets;
	}
	
	public static void sendNBATweets(String twitterHandle) {
		for (String tweet: getNBATweets()){
			Twitter4JUtility.publishTweet(tweet, twitterHandle);
		}
	}
}