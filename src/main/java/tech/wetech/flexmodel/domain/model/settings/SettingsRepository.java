package tech.wetech.flexmodel.domain.model.settings;

/**
 * @author cjbi
 */
public interface SettingsRepository {

  Settings saveSettings(Settings settings);

  Settings getSettings();

}
