package mp.req;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jian01.zhu on 2016/1/19.
 */
public class GetForeverChannelUrlBody {
    /**
     * action_name : QR_LIMIT_STR_SCENE
     * action_info : {"scene":{"scene_str":"123"}}
     */

    @SerializedName("action_name")
    private String actionName;
    /**
     * scene : {"scene_str":"123"}
     */

    @SerializedName("action_info")
    private ActionInfoEntity actionInfo;

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setActionInfo(ActionInfoEntity actionInfo) {
        this.actionInfo = actionInfo;
    }

    public String getActionName() {
        return actionName;
    }

    public ActionInfoEntity getActionInfo() {
        return actionInfo;
    }

    public static class ActionInfoEntity {
        /**
         * scene_str : 123
         */

        private SceneEntity scene;

        public void setScene(SceneEntity scene) {
            this.scene = scene;
        }

        public SceneEntity getScene() {
            return scene;
        }

        public static class SceneEntity {
            @SerializedName("scene_str")
            private String sceneStr;

            public void setSceneStr(String sceneStr) {
                this.sceneStr = sceneStr;
            }

            public String getSceneStr() {
                return sceneStr;
            }
        }
    }
}
