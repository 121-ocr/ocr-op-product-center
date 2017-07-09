package ocr.op.product.sku;

import java.util.ArrayList;
import java.util.List;

import otocloud.framework.app.function.AppActivityImpl;
import otocloud.framework.core.OtoCloudEventDescriptor;
import otocloud.framework.core.OtoCloudEventHandlerRegistry;

/**
 * TODO: 商品管理组件
 * @date 2016年11月26日
 * @author lijing
 */
public class SKUComponent extends AppActivityImpl {

	//业务活动组件名
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "product-sku";
	}
	
	//业务活动组件要处理的核心业务对象
	@Override
	public String getBizObjectType() {
		// TODO Auto-generated method stub
		return "p_ba_product_sku";
	}


	//发布此业务活动对外暴露的业务事件
	@Override
	public List<OtoCloudEventDescriptor> exposeOutboundBizEventsDesc() {
		// TODO Auto-generated method stub
		return null;
	}


	//业务活动组件中的业务功能
	@Override
	public List<OtoCloudEventHandlerRegistry> registerEventHandlers() {
		// TODO Auto-generated method stub
		List<OtoCloudEventHandlerRegistry> ret = new ArrayList<OtoCloudEventHandlerRegistry>();
		
		SKUCreateHandler skuCreateHandler = new SKUCreateHandler(this);
		ret.add(skuCreateHandler);

		SKUQueryHandler skuQueryHandler = new SKUQueryHandler(this);
		ret.add(skuQueryHandler);
		
		SKURemoveHandler skuRemoveHandler = new SKURemoveHandler(this);
		ret.add(skuRemoveHandler);
		
		SKUUpdateHandler skuUpdateHandler = new SKUUpdateHandler(this);
		ret.add(skuUpdateHandler);
		
		SKUFindOneQueryHandler skuFindOneQueryHandler = new SKUFindOneQueryHandler(this);
		ret.add(skuFindOneQueryHandler);
		
		return ret;
	}

}
