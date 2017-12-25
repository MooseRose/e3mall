package cn.e3mall.FastDFS;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class TestFastDFS {
	
	@Test
	public void testUpload() throws Exception {
		// 1.创建一个配置文件，配置TrackerServer的ip地址及端口号。
		// 2.加载配置文件。
		ClientGlobal.init("E:/workspace3/e3-manager-web/src/main/resources/conf/client.conf");
		// 3.创建一个TrackerClient对象。直接new
		TrackerClient trackerClient = new TrackerClient();
		// 4.使用TrackerClient获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5.创建一个StorageClient对象。需要两个参数，一个是TrackerServer对象，一个是StorageServer对象（可以为null）
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
		// 6.使用StorageClient对象上传文件。
		/**
		 * 参数一(local_filename):文件路径及文件名
		 * 参数二(file_ext_name):文件的扩展名,不带"."
		 * 参数三(meta_list):元数据(描述数据的属性信息)  ‪F:\1.jpg
		 */
		String[] arr = storageClient.upload_appender_file("F:/1.jpg", "jpg", null);
		for (String str : arr) {
			System.out.println(str);
		}
	}
	
	@Test
	public void testFastDFSClient() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("E:/workspace3/e3-manager-web/src/main/resources/conf/client.conf");
		String url = fastDFSClient.uploadFile("F:/2.png","png");
		String url2 = fastDFSClient.uploadFile("F:/3.png","png");
		System.out.println(url+"\n"+url2);
	}
	
}
