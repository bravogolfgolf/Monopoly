package game.interactors.versionoptions;

public interface VersionOptionsPresenter {

    void selectVersionPromptMessage();

    void availableVersionsMessage(VersionOptionsResponse response);

    void versionCreatedMessage(VersionOptionsResponse response);
}
