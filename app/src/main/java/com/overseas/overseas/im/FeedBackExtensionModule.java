package com.overseas.overseas.im;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imlib.model.Conversation;

/**
 * Created by   admin on 2018/4/28.
 */

public class FeedBackExtensionModule extends DefaultExtensionModule {
    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        List<IPluginModule> pluginModules = new ArrayList<>();
        pluginModules.add(new ImagePlugin());
//        pluginModules.add(new BaiduLocationPlugin());
        pluginModules.add(new CollectPlugin());
        return pluginModules;
    }
}
