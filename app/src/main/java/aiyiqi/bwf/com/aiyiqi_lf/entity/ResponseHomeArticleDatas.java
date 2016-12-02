package aiyiqi.bwf.com.aiyiqi_lf.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ResponseHomeArticleDatas {


    /**
     * data : [{"type":3,"id":"1218517","title":"刚刚装修完，就后悔的25件事！你中招了吗？","author":"long-北京","uid":"1531237","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1531237&size=big","dateline":"3小时前","sort":"1480484124","views":"83","replies":"1","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/30/132220j4l9nz1ia604ffzx.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218485","title":"地板第一次美容--厂家免费打精油","author":"雨筱逍1","uid":"1377565","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1377565&size=big","dateline":"9小时前","sort":"1480461950","views":"205","replies":"1","like_num":3,"path":"http://static-news.17house.com/web/bbs/201611/30/0722542002.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218482","title":"一分钟看懂八大主流装修风格！","author":"疯子的鞋","uid":"1487957","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1487957&size=big","dateline":"22小时前","sort":"1480415253","views":"230","replies":"2","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/29/180834yca6cviau1y5dm55.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218378","title":"过来人的经验 装修中最值得花钱的地方！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"2天前","sort":"1480406571","views":"287","replies":"1","like_num":2,"path":"http://static-news.17house.com/bbs/forum/201611/29/103413w7u3yw72suow8a7a.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218433","title":"圆我飘窗梦的它\u2014\u2014维盾门窗","author":"138****4572","uid":"1570556","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1570556&size=big","dateline":"2天前","sort":"1480404084","views":"707","replies":"7","like_num":10,"path":"http://static-news.17house.com/bbs/forum/201611/29/144757p21j61m25mn567ju.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218354","title":"工厂探秘之门窗篇：决战德高新工厂，品质实惠两手抓！","author":"怪兽","uid":"1482689","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big","dateline":"2天前","sort":"1480401897","views":"143","replies":"3","like_num":2,"path":"http://static-news.17house.com/bbs/forum/201611/29/130148x28a46bjxbz9ebxt.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"259785","title":"装修那么贵，钱都去哪儿了？","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/29/201611291418424832.jpg","views":637,"like_num":0,"replies":"2","dateline":"2天前","sort":"1480400640","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259785.html"},{"type":1,"id":"259769","title":"家中哪里颜值高？色彩搭配有门道","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/29/201611291327002997.jpg","views":220,"like_num":0,"replies":"0","dateline":"2天前","sort":"1480397220","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259769.html"},{"type":1,"id":"259763","title":"38平方米巧变4居室","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/29/201611291132558475.jpg","views":382,"like_num":0,"replies":"0","dateline":"2天前","sort":"1480390380","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259763.html"},{"type":1,"id":"259758","title":"看一看你跟明星的选择是否相同","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/29/201611291110337382.jpg","views":231,"like_num":0,"replies":"0","dateline":"2天前","sort":"1480389300","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259758.html"}]
     * newCount : 19
     * currentPage : 1
     * totalCount : 150
     * error : 0
     * message : 成功
     */

    private int newCount;
    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    /**
     * type : 3
     * id : 1218517
     * title : 刚刚装修完，就后悔的25件事！你中招了吗？
     * author : long-北京
     * uid : 1531237
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1531237&size=big
     * dateline : 3小时前
     * sort : 1480484124
     * views : 83
     * replies : 1
     * like_num : 1
     * path : http://static-news.17house.com/bbs/forum/201611/30/132220j4l9nz1ia604ffzx.jpg!w720
     * forum : {"fid":"2","name":"北京装修论坛"}
     * followed : 0
     */

    private List<DataBean> data;

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int type;
        private String id;
        private String title;
        private String author;
        private String uid;
        private String avtUrl;
        private String dateline;
        private String sort;
        private String views;
        private String replies;
        private int like_num;
        private String path;
        /**
         * fid : 2
         * name : 北京装修论坛
         */

        private ForumBean forum;
        private int followed;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public int getFollowed() {
            return followed;
        }

        public void setFollowed(int followed) {
            this.followed = followed;
        }

        public static class ForumBean {
            private String fid;
            private String name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
