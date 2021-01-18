package kz.alemtime.alem.support.navigation;

import android.support.v4.app.Fragment;

import kz.alemtime.alem.mvp.flow.login.LoginFragment;
import kz.alemtime.alem.mvp.flow.signUp.SignUpFragment;
import kz.alemtime.alem.mvp.pages.drawer_fragments.drawer_menu.FragmentDrawerMenu;
import kz.alemtime.alem.mvp.pages.page_alem_time.FragmentPageAlemTime;
import kz.alemtime.alem.mvp.pages.page_alem_time.page_alem_time_detailed_info.FragmentPageAlemTimeDetailedInfo;
import kz.alemtime.alem.mvp.pages.page_eldi_mekender.FragmentPageEldiMekender;
import kz.alemtime.alem.mvp.pages.page_eldi_mekender.page_eldi_mekender_detailed_info.FragmentPageEldiMekenderDetailedInfo;
import kz.alemtime.alem.mvp.tabContainer.TabContainerFragment;
import kz.alemtime.alem.mvp.tabsNavigation.FlowFragmentMain;
import kz.alemtime.alem.support.navigation.screen.ApplicationScreen;

public class Screens {

    public static ApplicationScreen getFlowTabsNavigation() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FlowFragmentMain.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Flow.flow_tabs_navigation.toString();
            }
        };
    }

    public static ApplicationScreen getFlowLogin() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return LoginFragment.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Flow.flow_login.toString();
            }
        };
    }

    public static ApplicationScreen getFlowSignUp() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return SignUpFragment.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Flow.flow_signup.toString();
            }
        };
    }

    public static ApplicationScreen getNavAlemTime() {
        String key = Tabs.nav_tab_alem_time.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getAlemTimePage(), Tabs.nav_tab_alem_time);
        return new ApplicationScreen() {
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

    private static ApplicationScreen getAlemTimePage() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentPageAlemTime.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Tab.page_alem_time.toString();
            }
        };
    }

    public static ApplicationScreen getAlemTimePageDetailedInfo() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentPageAlemTimeDetailedInfo.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Tab.page_alem_time_detailed_info.toString();
            }
        };
    }

    public static ApplicationScreen getNavEldiMekender() {
        String key = Tabs.nav_tab_eldi_mekender.toString();
        TabContainerFragment tabContainerFragment = TabContainerFragment.newInstance(Screens.getEldiMekenderPage(), Tabs.nav_tab_eldi_mekender);
        return new ApplicationScreen() {
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

    private static ApplicationScreen getEldiMekenderPage() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentPageEldiMekender.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Tab.page_eldi_mekender.toString();
            }
        };
    }

    public static ApplicationScreen getEldiMekenderPageDetailedInfo() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentPageEldiMekenderDetailedInfo.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Tab.page_eldi_mekender_detailed_info.toString();
            }
        };
    }

    public static ApplicationScreen getDrawerMenu() {
        return new ApplicationScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentDrawerMenu.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return Drawer.drawer_menu.toString();
            }
        };
    }

//    public static ApplicationScreen getDrawerAuth() {
//        return new ApplicationScreen() {
//            @Override
//            public Fragment getFragment() {
//                return FragmentDrawerAuth.Companion.newInstance();
//            }
//
//            @Override
//            public String getScreenKey() {
//                return Drawer.drawer_auth.toString();
//            }
//        };
//    }

    public enum Flow {
        flow_tabs_navigation,
        flow_login,
        flow_signup
    }

    public enum Drawer {
        drawer_menu,
        drawer_auth
    }
    public enum Tab {
        page_alem_time,
        page_eldi_mekender,
        page_alem_time_detailed_info,
        page_eldi_mekender_detailed_info
    }

    public enum Tabs {
        nav_tab_alem_time,
        nav_tab_eldi_mekender,
        nav_place_top_drawer
    }
}
