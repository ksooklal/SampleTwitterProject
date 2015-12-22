package NBA;

import java.util.ArrayList;

import Twitter4J.Twitter4JUtility;

public final class NBAAllStarTwitterVotingUtility {	
	public static final String [] EASTERN_CONFERENCE_PLAYERS = new String [] 
			{"John Wall", "Bradley Beal", "Marcin Gortat", "Gary Neal", "Jared Dudley",
					"Kris Humphries", "Ramon Sessions", "Garrett Temple"};
	public static final String [] WESTERN_CONFERENCE_PLAYERS = new String []
			{"Kobe Bryant", "Trevor Ariza"};
	
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