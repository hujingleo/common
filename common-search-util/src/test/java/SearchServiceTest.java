import com.ptteng.common.search.service.impl.QingSearchServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


//@Ignore
public class SearchServiceTest {

    private static final Log log = LogFactory.getLog(SearchServiceTest.class);

    public static void main(String[] args) {

        QingSearchServiceImpl searchUtil = new QingSearchServiceImpl();
        searchUtil.setUrl("120.132.71.211:9200");

//        String query = "{\"query\":{\"bool\":{\"must\":[{\"match\":{\"gender\":\"M\"}},{\"range\":{\"age\":{\"from\":30,\"to\":35}}}]}},\"from\":1,\"size\":1,\"sort\":[{\"age\":\"asc\"}]}";

//        String query = "{\n" +
//                "    \"query\": {\n" +
//                "        \"bool\": {\n" +
//                "            \"must\": [\n" +
//                "                {\n" +
//                "                    \"match\": {\n" +
//                "                        \"gender\": \"M\"\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"range\": {\n" +
//                "                        \"age\": {\n" +
//                "                            \"from\": 30,\n" +
//                "                            \"to\": 35\n" +
//                "                        }\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"from\": 1,\n" +
//                "    \"size\": 100,\n" +
//                "    \"sort\": [\n" +
//                "        {\n" +
//                "            \"age\": \"asc\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";

        String result = searchUtil.deleteDocument("sku", "11", 334L);



//        String result = searchUtil.getDocumentById("mobile","mi3",1L);
        log.info(result);

    }



}

