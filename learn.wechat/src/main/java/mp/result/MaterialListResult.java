package mp.result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/1/21.
 */
public class MaterialListResult {

    /**
     * item : [{"media_id":"uXFZMSSC2LV0MQ2rIDMR4wDIF8WKPBqDoN9mYDApA1M","content":{"news_item":[{"title":"1秒学会","author":"刘刚","digest":"啦啦啦啦啦啦啦啦","content":"<p>啦啦啦啦啦啦啦啦<\/p>","content_source_url":"","thumb_media_id":"Rdgk_wWQd2AwzKtWletMO9S58q0jXE3gV53nk3OV2VQ","show_cover_pic":1,"url":"http://mp.weixin.qq.com/s?__biz=MzA4MzczNTU2NQ==&mid=222441238&idx=1&sn=f6ca64fb3a236fd9f426f60e86502125#rd","thumb_url":"http://mmbiz.qpic.cn/mmbiz/pNUthtN6c6DsDF42AS9yYNzlCktcBjzKeqEEtaBqKXkDTX1ZiaQPMcStE46dk9jeGJicgicxKMUlsssSWmyVlP53g/0?wx_fmt=jpeg"}]},"update_time":1444704264}]
     * total_count : 2
     * item_count : 1
     */

    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("item_count")
    private int itemCount;
    /**
     * media_id : uXFZMSSC2LV0MQ2rIDMR4wDIF8WKPBqDoN9mYDApA1M
     * content : {"news_item":[{"title":"1秒学会","author":"刘刚","digest":"啦啦啦啦啦啦啦啦","content":"<p>啦啦啦啦啦啦啦啦<\/p>","content_source_url":"","thumb_media_id":"Rdgk_wWQd2AwzKtWletMO9S58q0jXE3gV53nk3OV2VQ","show_cover_pic":1,"url":"http://mp.weixin.qq.com/s?__biz=MzA4MzczNTU2NQ==&mid=222441238&idx=1&sn=f6ca64fb3a236fd9f426f60e86502125#rd","thumb_url":"http://mmbiz.qpic.cn/mmbiz/pNUthtN6c6DsDF42AS9yYNzlCktcBjzKeqEEtaBqKXkDTX1ZiaQPMcStE46dk9jeGJicgicxKMUlsssSWmyVlP53g/0?wx_fmt=jpeg"}]}
     * update_time : 1444704264
     */

    private List<ItemEntity> item;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setItem(List<ItemEntity> item) {
        this.item = item;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public List<ItemEntity> getItem() {
        return item;
    }

    public static class ItemEntity {
        @SerializedName("media_id")
        private String mediaId;
        private ContentEntity content;
        @SerializedName("update_time")
        private int updateTime;

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public void setContent(ContentEntity content) {
            this.content = content;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public String getMediaId() {
            return mediaId;
        }

        public ContentEntity getContent() {
            return content;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public static class ContentEntity {
            /**
             * title : 1秒学会
             * author : 刘刚
             * digest : 啦啦啦啦啦啦啦啦
             * content : <p>啦啦啦啦啦啦啦啦</p>
             * content_source_url :
             * thumb_media_id : Rdgk_wWQd2AwzKtWletMO9S58q0jXE3gV53nk3OV2VQ
             * show_cover_pic : 1
             * url : http://mp.weixin.qq.com/s?__biz=MzA4MzczNTU2NQ==&mid=222441238&idx=1&sn=f6ca64fb3a236fd9f426f60e86502125#rd
             * thumb_url : http://mmbiz.qpic.cn/mmbiz/pNUthtN6c6DsDF42AS9yYNzlCktcBjzKeqEEtaBqKXkDTX1ZiaQPMcStE46dk9jeGJicgicxKMUlsssSWmyVlP53g/0?wx_fmt=jpeg
             */

            @SerializedName("news_item")
            private List<NewsItemEntity> newsItem;

            public void setNewsItem(List<NewsItemEntity> newsItem) {
                this.newsItem = newsItem;
            }

            public List<NewsItemEntity> getNewsItem() {
                return newsItem;
            }

            public static class NewsItemEntity {
                private String title;
                private String author;
                private String digest;
                private String content;
                @SerializedName("content_source_url")
                private String contentSourceUrl;
                @SerializedName("thumb_media_id")
                private String thumbMediaId;
                @SerializedName("show_cover_pic")
                private int showCoverPic;
                private String url;
                @SerializedName("thumb_url")
                private String thumbUrl;

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public void setDigest(String digest) {
                    this.digest = digest;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public void setContentSourceUrl(String contentSourceUrl) {
                    this.contentSourceUrl = contentSourceUrl;
                }

                public void setThumbMediaId(String thumbMediaId) {
                    this.thumbMediaId = thumbMediaId;
                }

                public void setShowCoverPic(int showCoverPic) {
                    this.showCoverPic = showCoverPic;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setThumbUrl(String thumbUrl) {
                    this.thumbUrl = thumbUrl;
                }

                public String getTitle() {
                    return title;
                }

                public String getAuthor() {
                    return author;
                }

                public String getDigest() {
                    return digest;
                }

                public String getContent() {
                    return content;
                }

                public String getContentSourceUrl() {
                    return contentSourceUrl;
                }

                public String getThumbMediaId() {
                    return thumbMediaId;
                }

                public int getShowCoverPic() {
                    return showCoverPic;
                }

                public String getUrl() {
                    return url;
                }

                public String getThumbUrl() {
                    return thumbUrl;
                }
            }
        }
    }
}
