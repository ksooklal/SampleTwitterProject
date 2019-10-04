package TwitterAccounts;

public class TwitterUtility {

	public static void getAllTweets(Twitter twitter, String twitterHandle){
		List<Status> statuses;
		List<Status> allStatuses = new ArrayList<>();
		int count = 1;

		try {
			Paging page = new Paging (1, 50);
			for (int i = 1; i < 43; i++){
				page.setPage(i);
				twitter.verifyCredentials().getScreenName();
				statuses = twitter.getUserTimeline(twitterHandle, page);
				for (Status status: statuses) {
					allStatuses.add(status);
					System.out.println(status.getCreatedAt() + "\tTweet #" + count++ +
							" https://twitter.com/" + twitterHandle + "/status/" + status.getId() + 
							" - " + status.getText());
				}
			}
			System.out.println("Total # of Tweets Found: " + (count - 1));
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline at time" + new GregorianCalendar().getTime());
			System.exit(-1);
		}
	}
}
