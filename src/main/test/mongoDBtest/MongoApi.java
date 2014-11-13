package mongoDBtest;
import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class MongoApi {
	
	
	private static Long mongodb_size(String host, int port, String dbname, String username, String passwd) {
		Mongo m = null;
		DB db = null;
		Long usedSize = 0l;
		try {
			m = new Mongo(host, port);
			// 根据mongodb数据库的名称获取mongodb对象
			db = m.getDB(dbname);
			// 校验用户密码是否正确
//			if (!db.authenticate(username, passwd.toCharArray())) {
//			} else {
				db.requestStart();

				Set<String> collections = db.getCollectionNames();
				for (String collectionName : collections) {
					DBCollection collection = db.getCollection(collectionName);
//					Long indexsize = Long.valueOf(StringUtils.nullToEmpty(collection.getStats().get("totalIndexSize") + "", 1));
//					Long size = Long.valueOf(StringUtils.nullToEmpty(collection.getStats().get("size") + "", 1));
//					System.out.println(indexsize + size);
//					usedSize += indexsize + size;
				}

				db.requestDone();
//			}
		} catch (UnknownHostException e) {
//			logger.error(this.getClass().getSimpleName() + " mogodb_size error!" + e);
		} catch (MongoException e) {
//			logger.error(this.getClass().getSimpleName() + " mogodb_size error!" + e);
		}
		// mongodb连接关闭
		finally {
			if (null != m) {
				if (null != db) {
					// 结束Mongo数据库的事务请求
					try {
						db.requestDone();
					} catch (Exception e) {
//						logger.error(this.getClass().getSimpleName() + " mogodb_size error!" + e);
					}
				}
				try {
					m.close();
				} catch (Exception e1) {
//					logger.error(this.getClass().getSimpleName() + " mogodb_size error!" + e1);
				}
				m = null;
			}
		}

		return usedSize;
	}

	
	public static  void main(String args[]){
		System.out.println(mongodb_size("localhost",27017,"milliant",null,null));
	}

}
