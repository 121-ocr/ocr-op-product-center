package ocr.op.product.uom;

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
public class UOMComponent extends AppActivityImpl {

	//业务活动组件名
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "product-uom";
	}
	
	//业务活动组件要处理的核心业务对象
	@Override
	public String getBizObjectType() {
		// TODO Auto-generated method stub
		return "p_ba_uom";
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

		List<OtoCloudEventHandlerRegistry> ret = new ArrayList<OtoCloudEventHandlerRegistry>();
		
		UOMFindOneQueryHandler uomFindOneQueryHandler = new UOMFindOneQueryHandler(this);
		ret.add(uomFindOneQueryHandler);

		UOMQueryHandler uomQueryHandler = new UOMQueryHandler(this);
		ret.add(uomQueryHandler);
		
		return ret;
	}

}
