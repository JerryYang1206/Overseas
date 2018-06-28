package com.overseas.overseas.im;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;


import com.overseas.overseas.MyApplication;
import com.overseas.overseas.base.LoginActivity;
import com.overseas.overseas.utils.Constants;
import com.overseas.overseas.utils.SharedPreferencesUtils;

import java.io.File;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ImageMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;

/**
 * Created by   admin on 2018/4/20.
 */

public class ImManager {
    /**
     * 文本消息
     *
     * @param msg    消息内容
     * @param userId 用户ID
     */
    public static void sendTextMessage(String msg, String userId) {
        TextMessage myTextMessage = TextMessage.obtain(msg);
        Message myMessage = Message.obtain(userId, Conversation.ConversationType.PRIVATE, myTextMessage);

        RongIMClient.getInstance().sendMessage(myMessage, null, null, new IRongCallback.ISendMessageCallback() {
            @Override
            public void onAttached(Message message) {
                //消息本地数据库存储成功的回调
            }

            @Override
            public void onSuccess(Message message) {
                //消息通过网络发送成功的回调
                Log.e("MainActivity", "——发送成功—-");
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                //消息发送失败的回调
                Log.e("MainActivity", "——onError—-" +
                        errorCode);
            }
        });
    }

    /**
     * 图片消息
     *
     * @param imgUrl 图片地址
     * @param userId 用户ID
     */
    public static void sendImgMessage(Context context, String imgUrl, String userId) {
        /**
         * @param thumUri  缩略图地址。
         * @param localUri 大图地址。
         * @param isFull 是否发送原图。
         */
        ImageMessage myImageMessage = ImageMessage.obtain(null, getUri(imgUrl, context));

        /**
         * <p>根据会话类型，发送图片消息。</p>
         *
         * @param type        会话类型。
         * @param targetId    目标 Id。根据不同的 conversationType，可能是用户 Id、讨论组 Id、群组 Id 或聊天室 Id。
         * @param content     消息内容，例如 {@link TextMessage}, {@link ImageMessage}。
         * @param pushContent 当下发 push 消息时，在通知栏里会显示这个字段。
         *                    如果发送的是自定义消息，该字段必须填写，否则无法收到 push 消息。
         *                    如果发送 sdk 中默认的消息类型，例如 RC:TxtMsg, RC:VcMsg, RC:ImgMsg，则不需要填写，默认已经指定。
         * @param pushData    push 附加信息。如果设置该字段，用户在收到 push 消息时，能通过 {@link io.rong.push.notification.PushNotificationMessage#getPushData()} 方法获取。
         * @param callback    发送消息的回调。
         */
        RongIMClient.getInstance().sendImageMessage(Conversation.ConversationType.PRIVATE, userId, myImageMessage, null, null, new RongIMClient.SendImageMessageCallback() {

            @Override
            public void onAttached(Message message) {
                //保存数据库成功
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode code) {
                //发送失败
            }

            @Override
            public void onSuccess(Message message) {
                //发送成功
            }

            @Override
            public void onProgress(Message message, int progress) {
                //发送进度
            }
        });
    }

    /**
     * 语音消息
     *
     * @param voicePath 语音路径（AMR）
     * @param userId    用户ID
     */
    public static void sendVoiceMessage(String voicePath, String userId) {
        /**
         * 获取语音消息实体。
         *
         * @param Uri       语音 Uri 。
         * @param duration  语音时长（单位：秒）。
         */

        File voiceFile = new File(voicePath);
        VoiceMessage vocMsg = VoiceMessage.obtain(Uri.fromFile(voiceFile), 10);

        /**
         * <p>发送消息。
         * 通过 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}
         * 中的方法回调发送的消息状态及消息体。</p>
         *
         * @param message     将要发送的消息体。
         * @param pushContent 当下发 push 消息时，在通知栏里会显示这个字段。
         *                    如果发送的是自定义消息，该字段必须填写，否则无法收到 push 消息。
         *                    如果发送 sdk 中默认的消息类型，例如 RC:TxtMsg, RC:VcMsg, RC:ImgMsg，则不需要填写，默认已经指定。
         * @param pushData    push 附加信息。如果设置该字段，用户在收到 push 消息时，能通过 {@link io.rong.push.notification.PushNotificationMessage#getPushData()} 方法获取。
         * @param callback    发送消息的回调，参考 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}。
         */
        RongIMClient.getInstance().sendMessage(Conversation.ConversationType.PRIVATE, userId, vocMsg, null, null, new IRongCallback.ISendMessageCallback() {
            @Override
            public void onAttached(Message message) {
                //消息本地数据库存储成功的回调
            }

            @Override
            public void onSuccess(Message message) {
                //消息通过网络发送成功的回调
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                //消息发送失败的回调
            }
        });
    }

    /**
     * path转uri
     */
    private static Uri getUri(String path, Context context) {
        Uri uri = null;
        if (path != null) {
            path = Uri.decode(path);
//            Log.d(TAG, "path2 is " + path);
            ContentResolver cr = context.getContentResolver();
            StringBuffer buff = new StringBuffer();
            buff.append("(")
                    .append(MediaStore.Images.ImageColumns.DATA)
                    .append("=")
                    .append("'" + path + "'")
                    .append(")");
            Cursor cur = cr.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Images.ImageColumns._ID},
                    buff.toString(), null, null);
            int index = 0;
            for (cur.moveToFirst(); !cur.isAfterLast(); cur
                    .moveToNext()) {
                index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                // set _id value
                index = cur.getInt(index);
            }
            if (index == 0) {
                //do nothing
            } else {
                Uri uri_temp = Uri.parse("content://media/external/images/media/" + index);
//                Log.d(TAG, "uri_temp is " + uri_temp);
                if (uri_temp != null) {
                    uri = uri_temp;
                }
            }
        }
        return uri;
    }

    /**
     * 图文消息   项目中作为分享发送
     *
     * @param userId  用户id
     * @param title   分享标题
     * @param content 分享内容
     * @param imgUrl  分享图片
     * @param jumpUrl 跳转h5链接
     */
    public static void sendImgAndText(String userId, String title, String content, String imgUrl, String jumpUrl) {
        RichContentMessage richContentMessage = RichContentMessage.obtain(title, content, imgUrl);
        richContentMessage.setUrl(jumpUrl);

        //"9517" 为目标 Id。根据不同的 conversationType，可能是用户 Id、讨论组 Id、群组 Id 或聊天室 Id。
        //Conversation.ConversationType.PRIVATE 为会话类型。
        Message myMessage = Message.obtain(userId, Conversation.ConversationType.PRIVATE, richContentMessage);

        /**
         * <p>发送消息。
         * 通过 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}
         * 中的方法回调发送的消息状态及消息体。</p>
         *
         * @param message     将要发送的消息体。
         * @param pushContent 当下发 push 消息时，在通知栏里会显示这个字段。
         *                    如果发送的是自定义消息，该字段必须填写，否则无法收到 push 消息。
         *                    如果发送 sdk 中默认的消息类型，例如 RC:TxtMsg, RC:VcMsg, RC:ImgMsg，则不需要填写，默认已经指定。
         * @param pushData    push 附加信息。如果设置该字段，用户在收到 push 消息时，能通过 {@link io.rong.push.notification.PushNotificationMessage#getPushData()} 方法获取。
         * @param callback    发送消息的回调，参考 {@link io.rong.imlib.IRongCallback.ISendMessageCallback}。
         */
        RongIM.getInstance().sendMessage(myMessage, null, null, new IRongCallback.ISendMessageCallback() {
            @Override
            public void onAttached(Message message) {
                //消息本地数据库存储成功的回调
            }

            @Override
            public void onSuccess(Message message) {
                //消息通过网络发送成功的回调
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                //消息发送失败的回调
            }
        });
    }

    /**
     * 将某个用户加到黑名单中。
     * <p>当把对方加入黑名单后，对方再发消息时，就会提示“您的消息已经发出, 但被对方拒收”。但您仍然可以给对方发送消息。</p>
     *
     * @param userId 用户 Id。
     */
    public static void addToBlack(String userId, final Context context) {
        RongIM.getInstance().addToBlacklist(userId, new RongIMClient.OperationCallback() {
            @Override
            public void onSuccess() {
//                TUtils.showFail(context, "拉黑成功");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });
    }

    /**
     * 将个某用户从黑名单中移出。
     *
     * @param userId 用户 Id。
     */
    public static void removeFromBlack(String userId, final Context context) {
        RongIM.getInstance().removeFromBlacklist(userId, new RongIMClient.OperationCallback() {
            @Override
            public void onSuccess() {
//                TUtils.showFail(context, "移除成功");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });

    }

    public static void enterChatDetails(Context context, final String userId, final String chatName, final String avatar) {
//        if (!MyApplication.isLogin()) {
//            context.startActivity(new Intent(context, LoginActivity.class));
//            return;
//        }

        SharedPreferencesUtils.getInstace(context).setStringPreference(Constants.CHAT, Constants.CHAT_DETAILS);
        setMyExtensionModule();
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(context, userId, chatName);

            RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
                @Override
                public UserInfo getUserInfo(String s) {
                    return new UserInfo(userId + "", chatName, Uri.parse(avatar));
                }
            }, true);
        }
    }

    public static void enterChat(Context context, final String userId, final String chatName, final String avatar) {
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(context, userId, chatName);
            RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
                @Override
                public UserInfo getUserInfo(String s) {
                    return new UserInfo(userId + "", chatName, Uri.parse(avatar));
                }
            }, true);
        }
    }


    public static void setMyExtensionModule() {
        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new DetailsExtensionModule());
            }
        }
    }
}
