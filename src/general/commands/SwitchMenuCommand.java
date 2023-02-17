package general.commands;
import general.menus.IMenuView;
import general.enums.MenuType;
import general.models.MenuRepository;
import general.models.MenuService;
import general.models.MenuServiceImpl;

public class SwitchMenuCommand implements Command{
    IMenuView view;
    private MenuType menuType;
    public SwitchMenuCommand(MenuType menuType) {
        this.menuType = menuType;
    }

    @Override
    public void execute() {
        MenuService menuService = new MenuServiceImpl(new MenuRepository());
        menuService.setMenu(menuType);
        view = menuService.getView(menuType);
        view.display();
        menuService.getDescriptionList();
        view.displayMenuOptions(menuService.getDescriptionList());
        int input =  view.getInput();
        menuService.getCommand(input).execute();
    }
}
