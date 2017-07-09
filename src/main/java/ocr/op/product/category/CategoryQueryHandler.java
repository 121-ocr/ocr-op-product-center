package ocr.op.product.category;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonArray;
import otocloud.common.ActionURI;
import otocloud.common.OtoCloudDirectoryHelper;
import otocloud.framework.app.function.ActionDescriptor;
import otocloud.framework.app.function.ActionHandlerImpl;
import otocloud.framework.app.function.AppActivityImpl;
import otocloud.framework.core.CommandMessage;
import otocloud.framework.core.HandlerDescriptor;

/**
 * TODO: 产品分类树查询
 * @date 2016年11月15日
 * @author lijing
 */
public class CategoryQueryHandler extends ActionHandlerImpl<JsonArray> {
	
	public static final String ADDRESS = "findtree";

	public CategoryQueryHandler(AppActivityImpl appActivity) {
		super(appActivity);
		// TODO Auto-generated constructor stub
	}

	//此action的入口地址
	@Override
	public String getEventAddress() {
		// TODO Auto-generated method stub
		return ADDRESS;
	}

	//处理器
	@Override
	public void handle(CommandMessage<JsonArray> msg) {
		
		String menusFilePath = OtoCloudDirectoryHelper.getConfigDirectory() + "sales_catelogs.json";		
		
		this.getAppActivity().getVertx().fileSystem().readFile(menusFilePath, result -> {
    	    if (result.succeeded()) {
    	    	String fileContent = result.result().toString(); 
    	        
    	    	JsonArray srvCfg = new JsonArray(fileContent);
    	        msg.reply(srvCfg);     	        
    	        
    	    } else {
				Throwable errThrowable = result.cause();
				String errMsgString = errThrowable.getMessage();
				appActivity.getLogger().error(errMsgString, errThrowable);
				msg.fail(100, errMsgString);		
   
    	    }	
		});


	}
	

	/**
	 * 此action的自描述元数据
	 */
	@Override
	public ActionDescriptor getActionDesc() {		
		
		ActionDescriptor actionDescriptor = super.getActionDesc();
		HandlerDescriptor handlerDescriptor = actionDescriptor.getHandlerDescriptor();
		//handlerDescriptor.setMessageFormat("command");
		
		//参数
/*		List<ApiParameterDescriptor> paramsDesc = new ArrayList<ApiParameterDescriptor>();
		paramsDesc.add(new ApiParameterDescriptor("targetacc",""));		
		paramsDesc.add(new ApiParameterDescriptor("soid",""));		
		
		actionDescriptor.getHandlerDescriptor().setParamsDesc(paramsDesc);	*/
				
		ActionURI uri = new ActionURI(ADDRESS, HttpMethod.GET);
		handlerDescriptor.setRestApiURI(uri);
		
		return actionDescriptor;
	}
	
	
}
