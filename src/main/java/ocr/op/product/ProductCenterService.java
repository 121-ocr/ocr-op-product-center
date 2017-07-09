package ocr.op.product;

import java.util.ArrayList;
import java.util.List;

import ocr.op.product.category.CategoryComponent;
import ocr.op.product.spu.ProductComponent;
import otocloud.framework.app.engine.AppServiceImpl;
import otocloud.framework.app.engine.WebServer;
import otocloud.framework.app.function.AppActivity;
import otocloud.framework.app.function.AppInitActivityImpl;

/**
 * TODO: 产品中心微服务
 * @date 2016年11月26日
 * @author lijing@yonyou.com
 */
public class ProductCenterService extends AppServiceImpl
{

	//创建服务初始化组件
	@Override
	public AppInitActivityImpl createAppInitActivity() {		
		return null;
	}

	//创建租户级web server
	@Override
	public WebServer createWebServer() {
		// TODO Auto-generated method stub
		return null;
	}

	//创建服务内的业务活动组件
	@Override
	public List<AppActivity> createBizActivities() {
		List<AppActivity> retActivities = new ArrayList<>();		
	
		CategoryComponent catelogComponent = new CategoryComponent();
		retActivities.add(catelogComponent);
		
		ProductComponent productComponent = new ProductComponent();
		retActivities.add(productComponent);

		return retActivities;
	}
}
