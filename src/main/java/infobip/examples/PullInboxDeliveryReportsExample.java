package infobip.examples;

import infobip.api.client.GetReceivedSmsLogs;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mo.logs.MOLog;
import infobip.api.model.sms.mo.logs.MOLogsResponse;

/**
 * Created by milosmilakovic on 9/24/15.
 */
public class PullInboxDeliveryReportsExample extends Example {

    public static void main(String[] args) {
        GetReceivedSmsLogs client = new GetReceivedSmsLogs(new BasicAuthConfiguration(USERNAME, PASSWORD));

        MOLogsResponse response = client.execute(null, null, null, 10, null);

        for (int i = 0; i < response.getResults().size(); ++i) {
            MOLog result = response.getResults().get(i);
            System.out.println("Message ID: " + result.getMessageId());
            System.out.println("Received at: " + result.getReceivedAt());
            System.out.println("Sender: " + result.getFrom());
            System.out.println("Receiver: " + result.getTo());
            System.out.println("Message text: " + result.getText());
            System.out.println("Keyword: " + result.getKeyword());
            System.out.println("Clean text: " + result.getCleanText());
            System.out.println("Sms Count: " + result.getSmsCount());
        }
    }
}