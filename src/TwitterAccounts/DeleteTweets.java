package TwitterAccounts;

public class DeleteTweets {
	public static void deleteTweetsByStatusIds(Twitter twitter, Long [] statusIds){
		int countDeleted = 0;
		for (long statusId: statusIds) {
			try {
				twitter.destroyStatus(statusId);
				countDeleted++;
				System.out.println("Successfully deleted status #" + statusId + "");
			} catch (TwitterException te) {
				if (!te.getMessage().contains("404")) {
					te.printStackTrace();
					System.out.println("Failed to delete status #" + statusId + "\n" + te.getMessage());
				} else {
					System.out.println("Failed to delete status #" + statusId);
				}
			}
		}
		System.out.println("Successfully deleted " + countDeleted + " out of " + statusIds.length + " tweet statuses.");
	}

	public static void deleteTweetsByStatusIds(Twitter twitter, List<Long> statusIds) {
		int countDeleted = 0;

		if (statusIds != null && statusIds.size() > 0) {
			for (long statusId : statusIds) {
				try {
					twitter.destroyStatus(statusId);
					countDeleted++;
					System.out.println("Successfully deleted status [" + statusId + "].");
				} catch (TwitterException te) {
					if (!te.getMessage().contains("404")) {
						te.printStackTrace();
						System.out.println("Failed to delete status #" + statusId + "\n" + te.getMessage());
					} else {
						System.out.println("Failed to delete status #" + statusId);
					}
				}
			}
			System.out.println(
					"Successfully deleted " + countDeleted + " out of " + statusIds.size() + " tweet statuses.");
		}
	}
}
