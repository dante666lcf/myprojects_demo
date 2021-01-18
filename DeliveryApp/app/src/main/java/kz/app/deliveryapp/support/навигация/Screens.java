package kz.app.deliveryapp.support.навигация;

import android.support.v4.app.Fragment;
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem;
import kz.app.deliveryapp.mvp.страницы.акции.FragmentAksii;
import kz.app.deliveryapp.mvp.страницы.корзина.FragmentBasket;
import kz.app.deliveryapp.mvp.страницы.детальная_информация_еды.FragmentDetailedInfo;
import kz.app.deliveryapp.mvp.страницы.меню.FragmentMenu;
import kz.app.deliveryapp.mvp.страницы.меню_раздел.FragmentMenuRazdel;
import kz.app.deliveryapp.mvp.страницы.новости.FragmentNews;
import kz.app.deliveryapp.mvp.tabContainer.TabContainerFragment;
import kz.app.deliveryapp.mvp.tabsNavigation.FlowFragmentMain;
import kz.app.deliveryapp.support.навигация.screen.BenderScreen;

public class Screens {

    //TODO: изменить название скрина
    public static BenderScreen getFlowTabsNavigation() {
        return new BenderScreen() {
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

    public static BenderScreen getNavTabMenu() {
        final String key = Tabs.nav_tab_menu.toString();
        final TabContainerFragment navTabContainerFragment = TabContainerFragment.newInstance(Screens.getMenuList(), Tabs.nav_tab_menu);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return navTabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    public static BenderScreen getNavTabAksii() {
        final String key = Tabs.nav_tab_aksii.toString();
        final TabContainerFragment navTabContainerFragment = TabContainerFragment.newInstance(Screens.getAksiiList(), Tabs.nav_tab_aksii);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return navTabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    public static BenderScreen getNavTabNews() {
        final String key = Tabs.nav_tab_news.toString();
        final TabContainerFragment navTabContainerFragment = TabContainerFragment.newInstance(Screens.getNewsList(), Tabs.nav_tab_news);
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return navTabContainerFragment;
            }

            @Override
            public String getScreenKey() {
                return key;
            }
        };
    }

    private static BenderScreen getMenuList() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentMenu.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getMenuRazdelList(final String type) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentMenuRazdel.Companion.newInstance(type);
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    private static BenderScreen getAksiiList() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentAksii.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    private static BenderScreen getNewsList() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentNews.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getBasketList() {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentBasket.Companion.newInstance();
            }

            @Override
            public String getScreenKey() {
                return super.getScreenKey();
            }
        };
    }

    public static BenderScreen getFlowDetailedInfo(final TEdaItem edaItem) {
        return new BenderScreen() {
            @Override
            public Fragment getFragment() {
                return FragmentDetailedInfo.Companion.newInstance(edaItem);
            }

            @Override
            public String getScreenKey() {
                return Flow.flow_detailed_info.toString();
            }
        };
    }


    public enum Flow {
        flow_tabs_navigation,
        flow_detailed_info
    }

    public enum Tabs {
        nav_tab_menu,
        nav_tab_favorites,
        nav_tab_news,
        nav_tab_aksii
    }
}
