/**
 * Producer to sending message to "custom" topic.
 */
@Component
public class ProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
    private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);


	public void postMessage( List<String> toSend) 
	
	{
		
		ListenableFutureCallback<SendResult<String, String>> callback = new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOG.info("Success: "  + result.getProducerRecord().value());
                int i =1/0;
            }

            @Override
            public void onFailure(Throwable ex) {
                ProducerRecord<?, ?> producerRecord = ((KafkaProducerException) ex).getFailedProducerRecord();
                LOG.error("Failed; " + producerRecord.value(), ex);
               
            }
        };
        
        
     // wrapping the send method in a transaction
		this.kafkaTemplate.executeInTransaction(kt -> {
			for (String str : toSend) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ListenableFuture<SendResult<String, String>> future = kt.send("mytopic", str);
				future.addCallback(callback);
				
			}

			 
			
			
			return kt;

		});
		 
		 
		 
		
		System.out.println(" In Post message ---------------------");
        
       
		
	}
	
	
	
}
