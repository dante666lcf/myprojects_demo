package kz.alemtime.alem.support.provider;

public class FragmentProvider {

    //region Vars
    private Integer layoutResourceId;
    private Integer toolbarArrowColor;
    private Integer toolbarHamburgerColor;
    private Integer toolbarTitleColor;
    private String toolbarTitle;
    private Boolean hasOptions = false;
    //endregion

    //region Constructor
    public FragmentProvider() {

    }
    //endregion

    //region Builder
    public FragmentProvider setLayoutResourceId(int layoutResourceId) {
        this.layoutResourceId = layoutResourceId;
        return this;
    }

    public FragmentProvider setToolbarArrowColor(Integer toolbarArrowColor) {
        this.toolbarArrowColor = toolbarArrowColor;
        return this;
    }

    public FragmentProvider setToolbarHamburgerColor(Integer toolbarHamburgerColor) {
        this.toolbarHamburgerColor = toolbarHamburgerColor;
        return this;
    }

    public FragmentProvider setToolbarTitle(String toolbarTitle, Integer toolbarTitleColor) {
        this.toolbarTitle = toolbarTitle;
        this.toolbarTitleColor = toolbarTitleColor;
        return this;
    }

    public FragmentProvider setHasOptions(Boolean hasOptions) {
        this.hasOptions = hasOptions;
        return this;
    }
    //endregion

    //region Getters
    public Integer getLayoutResourceId() {
        return layoutResourceId;
    }

    public Integer getToolbarArrowColor() {
        return toolbarArrowColor;
    }

    public Integer getToolbarHamburgerColor() {
        return toolbarHamburgerColor;
    }

    public Integer getToolbarTitleColor() {
        return toolbarTitleColor;
    }

    public String getToolbarTitle() {
        return toolbarTitle;
    }

    public Boolean getHasOptions() {
        return hasOptions;
    }
    //endregion
}