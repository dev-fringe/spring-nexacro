# spring-nexacro
그냥 ...
--
17:19:41.705 [main] DEBUG com.nexacro.spring.resolve.NexacroMethodArgumentResolver - NexacroMethodArgumnetResolver() com.nexacro.spring.resolve.NexacroMethodArgumentResolver@3697186
17:19:42.121 [main] DEBUG com.nexacro.spring.servlet.NexacroInterceptor - got request=[variable=[
	index=0 (varInt, int, "1")
	, index=1 (varString, string, "park")
]
---------- index=000 ----------
name=ds, alias=ds, columnCount=12, rowCount=2, charset=null, isStoreDataChanges=true
, column=[
	index=0 (access, bigdecimal, 8)
	, index=1 (commissionPercent, double, 8)
	, index=2 (email, string, 32)
	, index=3 (employeeId, int, 4)
	, index=4 (firstName, string, 32)
	, index=5 (height, double, 4)
	, index=6 (hireDate, datetime, 17)
	, index=7 (image, blob, 256)
	, index=8 (lastName, string, 32)
	, index=9 (male, int, 2)
	, index=10 (obj, undefined, 0)
	, index=11 (salary, bigdecimal, 16)
]
, row=[
	index=0 normal ("11", "11.1", "seongmin@tobesoft.com", "11", "seongmin", "180.1", "20090101134516072", blob[2], "park", "1", "java.lang.Object@1c7e2da", "10001")
	, index=1 normal ("12", "11.2", "hyena@tobesoft.com", "12", "hyena", "180.2", "20090102134516072", blob[2], "lee", "0", "java.lang.Object@69fe571f", "10002")
]]
17:19:42.141 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.DataSetToListConverter registered.
17:19:42.141 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.ListToDataSetConverter registered.
17:19:42.141 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.DataSetToObjectConverter registered.
17:19:42.142 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.ObjectToDataSetConverter registered.
17:19:42.142 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.VariableToObjectConverter registered.
17:19:42.143 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - class com.nexacro.spring.data.support.ObjectToVariableConverter registered.
17:19:42.144 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - com.nexacro.xapi.data.DataSet to java.util.Map converter(com.nexacro.spring.data.support.DataSetToObjectConverter) registered.
com.nexacro.xapi.data.DataSet@fb9c7aa
{image=[B@4c398c80, lastName=park, hireDate=Thu Jan 01 13:45:16 KST 2009, access=11, employeeId=11, salary=10001, firstName=seongmin, obj=java.lang.Object@1c7e2da, DataSetRowType=0, commissionPercent=11.1, email=seongmin@tobesoft.com, male=1, height=180.1}
17:19:42.152 [main] DEBUG com.nexacro.spring.data.convert.NexacroConverterFactory - java.lang.String to com.nexacro.xapi.data.Variable converter(com.nexacro.spring.data.support.ObjectToVariableConverter) registered.
17:19:42.152 [main] DEBUG com.nexacro.spring.resolve.NexacroHandlerMethodReturnValueHandler - found a converter(com.nexacro.spring.data.support.ObjectToVariableConverter) for converting the class java.lang.String to Variable(ErrorMsg)
17:19:42.152 [main] DEBUG com.nexacro.spring.resolve.NexacroHandlerMethodReturnValueHandler - found a converter(com.nexacro.spring.data.support.ObjectToVariableConverter) for converting the class java.lang.String to Variable(ErrorCode)
17:19:42.163 [main] DEBUG com.nexacro.spring.view.NexacroView - response platformdata=[variable=[
	index=0 (ErrorMsg, string, "success")
	, index=1 (ErrorCode, string, "12323")
]
]

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /workflow/iom/iomListNexa
       Parameters = {}
          Headers = [Content-Type:"text/xml", user-agent:"Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25", Content-Length:"2409"]
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = dev.fringe.app.controller.HomeController
           Method = dev.fringe.app.controller.HomeController#iomListNexa(HttpSession, PlatformData, Map)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = com.nexacro.spring.view.NexacroView: name 'nexacroView'
        Attribute = NexacroPlatformData
            value = com.nexacro.xapi.data.PlatformData@5b07730f
           errors = []

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Language:"en", Content-Type:"text/xml; charset=UTF-8"]
     Content type = text/xml; charset=UTF-8
             Body = <?xml version="1.0" encoding="UTF-8"?>
<Root xmlns="http://www.nexacro.com/platform/dataset" ver="5000">
	<Parameters>
		<Parameter id="ErrorMsg" type="string">success</Parameter>
		<Parameter id="ErrorCode" type="string">12323</Parameter>
	</Parameters>
</Root>

    Forwarded URL = null
   Redirected URL = null
          Cookies = []
