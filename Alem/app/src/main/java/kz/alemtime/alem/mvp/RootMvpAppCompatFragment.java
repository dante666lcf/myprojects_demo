package kz.alemtime.alem.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.balysv.materialmenu.MaterialMenuDrawable;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kz.alemtime.alem.R;
import kz.alemtime.alem.mvp.main.MainActivity;
import kz.alemtime.alem.support.navigation.ApplicationRouter;
import kz.alemtime.alem.support.navigation.RouterProvider;
import kz.alemtime.alem.support.provider.FragmentProvider;

public abstract class RootMvpAppCompatFragment<T extends AbstractPresenter> extends MvpAppCompatFragment
        implements AbstractView {

    //region Views
    protected View rootView;
    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    protected Menu menuItems;
    //endregion

    //region Vars
    protected MainActivity activity;
    private FragmentProvider fragmentProvider;
    private Unbinder unbinder;
    private T presenter;
    //endregion

    //region Abstract
    @NonNull
    public abstract FragmentProvider getFragmentProvider();

    @NotNull
    protected abstract T getPresenter();
    //endregion

    //region Overridden methods
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
        fragmentProvider = getFragmentProvider();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(fragmentProvider.getLayoutResourceId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);

        if (toolbar != null) {
            if (fragmentProvider.getHasOptions()) {
                activity.setSupportActionBar(toolbar);
                setHasOptionsMenu(true);
            }
            if (fragmentProvider.getToolbarTitle() != null)
                toolbar.setTitle(fragmentProvider.getToolbarTitle());

            if (fragmentProvider.getToolbarTitleColor() != null)
                toolbar.setTitleTextColor(ContextCompat.getColor(activity, fragmentProvider.getToolbarTitleColor()));

            if (fragmentProvider.getToolbarArrowColor() != null) {
                MaterialMenuDrawable materialMenu = new MaterialMenuDrawable(activity,
                        ContextCompat.getColor(activity, fragmentProvider.getToolbarArrowColor()),
                        MaterialMenuDrawable.Stroke.THIN);
                materialMenu.setIconState(MaterialMenuDrawable.IconState.ARROW);
                toolbar.setNavigationIcon(materialMenu);
                toolbar.setNavigationOnClickListener(v -> presenter.exit());
            }

            if (fragmentProvider.getToolbarHamburgerColor() != null) {
                MaterialMenuDrawable materialMenu = new MaterialMenuDrawable(activity,
                        ContextCompat.getColor(activity, fragmentProvider.getToolbarHamburgerColor()),
                        MaterialMenuDrawable.Stroke.THIN);
                materialMenu.setIconState(MaterialMenuDrawable.IconState.BURGER);
                toolbar.setNavigationIcon(materialMenu);
            }
        }

        presenter = getPresenter();
        presenter.onCreateView(rootView, null);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume(getRouter());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden)
            presenter.onHidden();
        else {
            presenter.onShown();
        }

        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment.isVisible()) {
                fragment.onHiddenChanged(hidden);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        presenter = null;
        super.onDetach();
    }
    //endregion

    //region Actions
    public void exit() {
        presenter.exit();
    }
    //endregion

    protected ApplicationRouter getRouter() {
        if (getParentFragment() != null && getParentFragment() instanceof RouterProvider) {
            return ((RouterProvider) getParentFragment()).provideRouter();
        } else {
            return activity.provideRouter();
        }
    }

    protected ApplicationRouter getTabTopNavRouter() {
        return activity.provideTabTopNavRouter();
    }

    //region UI
    @Override
    public void showRequestError(Throwable throwable) {
//        if (throwable == null)
//            ZUtils.showRequestError(activity);
//        else if (throwable.getCause() != null) {
//            Integer errorCode;
//            try {
//                errorCode = Integer.valueOf(throwable.getCause().getMessage());
//            } catch (Exception e) {
//                errorCode = null;
//            }
//            if (errorCode != null)
//                ZUtils.showResponseError(activity, errorCode, throwable.getMessage());
//            ZUtils.showRequestError(throwable);
//        }
    }

    @Override
    public void showResponseError(int responseResultCode, String responseResultMessage) {
//        ZUtils.showResponseError(activity, responseResultCode, responseResultMessage);
    }
    //endregion
}