package kz.app.bender.support.provider;

public class FragmentProvider {

    //region Vars
    private Integer layoutResourceId;
    private Integer toolbarArrowColor;
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

    public FragmentProvider setToolbarTitle(String toolbarTitle) {
        this.toolbarTitle = toolbarTitle;
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

    public String getToolbarTitle() {
        return toolbarTitle;
    }

    public Boolean getHasOptions() {
        return hasOptions;
    }
    //endregion
}