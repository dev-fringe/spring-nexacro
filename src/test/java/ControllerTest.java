
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nexacro.xapi.data.DataSet;
import com.nexacro.xapi.data.PlatformData;
import com.nexacro.xapi.data.datatype.PlatformDataType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context-common.xml")
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test12() throws Exception {
        String requestFileName = "src/test/java/httpRequest.xml";
        InputStream requestInputStream = new FileInputStream(new File(requestFileName));
        byte[] byteArray = IOUtils.toByteArray(requestInputStream);
        DataSet ds = new DataSet("ds");
        ds.addColumn("name", PlatformDataType.STRING);
        int newRow = ds.newRow();
        ds.set(newRow, "name", "tom");
        PlatformData data = new PlatformData();
        data.addDataSet(ds);
//        System.out.println( data.saveXml());
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/workflow/iom/iomListNexa").content(byteArray).contentType(MediaType.TEXT_XML).with(remoteAddr("0.0.0.0"))
                        .header("user-agent",
                                "Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25")
//                        .param("dsIOMList", "8141").param("sObjectId", "090027118000b0a1")
                        )
                .andDo(print()).andExpect(status().isOk());
    }

    private static RequestPostProcessor remoteAddr(final String remoteAddr) {
        return new RequestPostProcessor() {
            @Override
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                request.setRemoteAddr(remoteAddr);
                return request;
            }
        };
    }
    
    public static void main(String arg[]){
        DataSet ds = new DataSet("ds");
        ds.addColumn("name", PlatformDataType.STRING);
        int newRow = ds.newRow();
        ds.set(newRow, "name", "tom");
        PlatformData data = new PlatformData();
        data.addDataSet(ds);
        System.out.println( data.saveXml());
    }
}
