package kz.app.bender.support.navigation;

import android.support.v4.app.Fragment;

import kz.app.bender.models.TChildrenItem;
import kz.app.bender.models.TDate;
import kz.app.bender.mvp.listChildren.ChildrenFragment;
import kz.app.bender.mvp.login.LoginFragment;
import kz.app.bender.mvp.scanQr.ScanQRFragment;
import kz.app.bender.mvp.scanQr.errorQr.ScanQRErrorFragment;
import kz.app.bender.mvp.scanQr.successQr.ScanQRSuccessFragment;
import kz.app.bender.mvp.tabContainer.TabContainerFragment;
import kz.app.bender.mvp.tabsNavigation.FlowFragmentMain;
import kz.app.bender.mvp.webView.WebViewFragment;
import kz.app.bender.support.navigation.screen.BenderScreen;

public class Screens {

    public static BenderScreen getFlowTabsNavigation() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FlowFragmentMain.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Flow.flow_tabs_navigation.toString();
            }
        };
    }

    //region Tabs
    public static BenderScreen getTabLogin() {
        String key = Tabs.tab_login.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getLogin(), Tabs.tab_login);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return tabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    public static BenderScreen getTabWebView(String stringUrl) {
        String key = Tabs.tab_web_site_karlygash.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getWebView(stringUrl), Tabs.tab_web_site_karlygash);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return tabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    public static BenderScreen getTabWebView2(String stringUrl) {
        String key = Tabs.tab_web_site_profile.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getWebView(stringUrl), Tabs.tab_web_site_profile);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return tabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    public static BenderScreen getTabChildrenList() {
        String key = Tabs.tab_children_list.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getChildrenList(), Tabs.tab_children_list);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return tabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }
    //endregion

    public static BenderScreen getWebView(String stringUrl) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return WebViewFragment.Companion.newInstance(stringUrl);
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getLogin() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return LoginFragment.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getScanQR(TChildrenItem childrenItem) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return ScanQRFragment.Companion.newInstance(childrenItem);
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getChildrenList() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return ChildrenFragment.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getScanQrSuccess(TDate dateNoteChild) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return ScanQRSuccessFragment.Companion.newInstance(dateNoteChild);
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getScanQrError(TChildrenItem childrenItem) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return ScanQRErrorFragment.Companion.newInstance(childrenItem);
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public enum Flow {
        flow_tabs_navigation
    }

    public enum Tabs {
        tab_login,
        tab_children_list,
        tab_web_site_karlygash,
        tab_web_site_profile
    }
}
