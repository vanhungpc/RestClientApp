package com.pkt.rest.client.services;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Comment;

public class CommentService extends BaseService {

	public static String _PATH = "comment";

	protected static CommentService instance;

	public static CommentService getInstance() {
		if (instance == null)
			instance = new CommentService();

		return instance;
	}
	public String temp;
	public String getJsonString() {
		temp = this.getJsonString(_PATH);

		return temp;
	}

	public String getJsonString(int id) {
		temp = this.getJsonString(id);

		return temp;
	}

	public String getCommentAndroid() {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CommentService._PATH;
		String str = service.get(path, null);

		return str;
	}

	public String getCommentAndroid(String id) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CommentService._PATH;
		String str = service.get(path, id);

		return str;
	}

	public String createCommentAndroid(Comment object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CommentService._PATH + "/create";

		return service.postGetId(path, object);
	}


	public boolean updateCommentAndroid(Comment object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CommentService._PATH + "/update";

		return service.post(path, object);
	}

	public boolean deleteCommentAndroid(Comment object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CommentService._PATH + "/delete";

		return service.post(path, object);
	}

}
