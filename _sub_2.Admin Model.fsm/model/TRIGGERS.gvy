// Trigger script - define one function for each state or transition to be executed when traversed,
// To add a trigger: Ctrl/Cmd-I and select the state or transition.
// Do not remove the following import statement.

import com.testoptimal.mscript.groovy.TRIGGER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration
import org.openqa.selenium.support.ui.Select;

@TRIGGER('MBT_START')
def 'MBT_START' () {
	if ($SYS.isSubModel()){
		$SELENIUM.setBrowser($SYS.getExecDir().getExecSetting().getOption('ideBrowser'));
	}
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
	$VAR.TotalProduct = 0;
	$VAR.HasDeleteProduct = false;
	$VAR.HasDeleteUser = false;
}


@TRIGGER('U2d3a6b8f')
def 'Start: e_Access_Home_Page'() {
	if ($SYS.isSubModel()){
		$SELENIUM.getWebDriver().get('http://127.0.0.1:8000/');
	}
}


@TRIGGER('Ua2bf1d29')
def 'v_Home_Page: e_Access_Login_Page'() {
	if ($VAR.HasLogin == false){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Login_Element.click();
	}else if ($VAR.HasLogin){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Main_Dashboard_Element.click();

		WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
		End_Element_1.click();

		WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
		End_Element_2.click();
		$VAR.HasLogin = false;
		$VAR.HasAddProduct = false;
		$VAR.HasAddUser = false;
	}
}


@TRIGGER('U20e0575e')
def 'v_Login_Page: e_Access_Main_Dashboard_Page'() {
	email = $SYS.getData('email');
	password = $SYS.getData('password');

	$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
	$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
	$VAR.HasLogin = true;
}


@TRIGGER('Udc1bb446')
def 'v_Main_Dashboard_Page: e_Return_Home_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Home_Page_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000' and contains(@class, 'bg-green-500 rounded-full px-4 py-2 mx-4 my-4 text-xs font-semibold text-white')]")));
	Home_Page_Element.click();
}


@TRIGGER('Ue0c8b947')
def 'v_Home_Page: e_Access_Main_Dashboard_Page'() {
	if ($VAR.HasLogin == true) {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Main_Dashboard_Element.click();
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Login_Element.click();

		email = $SYS.getData('email');
		password = $SYS.getData('password');

		$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
		$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
		$VAR.HasLogin = true;
	}
}


@TRIGGER('Ud9644e19')
def 'v_Main_Dashboard_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U36f45de7')
def 'v_Create_Product_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U320e98fe')
def 'v_Create_Product_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('Ue7abf75c')
def 'v_Create_Product_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U070b6580')
def 'v_Create_Product_Page: e_Return_Dashboard_Product_Page'() {
	if ($VAR.TotalProduct == 0){
		name = $SYS.getData('name');
		description = $SYS.getData('description');
		price = $SYS.getData('price');

		$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500' and contains(@id, 'grid-last-name') and contains(@type, 'text')]")).sendKeys(name);

		JavascriptExecutor js = (JavascriptExecutor) $SELENIUM.getWebDriver();
		Actions actions = new Actions($SELENIUM.getWebDriver());
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", $SELENIUM.getWebDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

		actions.pause(Duration.ofSeconds(1)).perform();

		WebElement textareaElement = $SELENIUM.getWebDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		textareaElement.click();

		textareaElement.sendKeys(description);
		textareaElement.click();
		textareaElement.sendKeys(description);

		$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500' and contains(@id, 'grid-last-name') and contains(@type, 'number')]")).sendKeys(price);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class=' shadow-lg bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded']")).click();
		$VAR.HasAddProduct = true;
		$VAR.TotalProduct += 1;
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
		Dashboard_Product_Element.click();
	}
}


@TRIGGER('Uc24d1e57')
def 'v_Create_Product_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U0a050779')
def 'v_Dashboard_Product_Page: e_Access_Create_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Create_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product/create' and contains(@class, 'bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded shadow-lg')]")));
	Create_Product_Element.click();
}


@TRIGGER('Ue661c6c9')
def 'v_Dashboard_Product_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U49b3abf7')
def 'v_Dashboard_Product_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('U14df5506')
def 'v_Dashboard_Product_Page: e_Access_Edit_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Edit_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product/10/edit' and contains(@class, 'bg-green-500 mr-2 text-white rounded-md px-2 py-1 m-2')]")));
	Edit_Product_Element.click();
}


@TRIGGER('U1388b5b6')
def 'v_Dashboard_Product_Page: e_Access_Gallery_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Gallery_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product/10/gallery' and contains(@class, 'bg-black mr-2 text-white rounded-md px-2 py-1 m-2')]")));
	Gallery_Product_Element.click();
}


@TRIGGER('Ue8585a76')
def 'v_Dashboard_Product_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U312da86c')
def 'v_Dashboard_Product_Page: e_Return_Dashboard_Product_Page'() {
	if ($VAR.HasDeleteProduct == false){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='bg-red-600 text-white rounded-md px-2 py-1 m-2 transition duration-500 ease select-none hover:bg-red-600 focus:outline-none focus:shadow-outline']")));
		Dashboard_Product_Element.click();
		$VAR.HasDeleteProduct = true;
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
		Dashboard_Product_Element.click();
	}
}


@TRIGGER('U837aa343')
def 'v_Dashboard_Product_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('Ua3d1d7f8')
def 'v_Dashboard_Transaction_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('Uf6234b72')
def 'v_Dashboard_Transaction_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('Ub1c4350d')
def 'v_Dashboard_Transaction_Page: e_Access_Edit_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Edit_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction/1/edit' and contains(@class, 'bg-black text-white rounded-md px-2 py-1 m-2')]")));
	Edit_Transaction_Element.click();
}


@TRIGGER('Uc127d329')
def 'v_Dashboard_Transaction_Page: e_Access_Show_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Show_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction/1' and contains(@class, 'bg-black text-white rounded-md px-2 py-1 m-2')]")));
	Show_Transaction_Element.click();
}


@TRIGGER('Ub49232ad')
def 'v_Dashboard_Transaction_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('Uec8ae8bd')
def 'v_Dashboard_Transaction_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U77969cba')
def 'v_Dashboard_User_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('Uc321a277')
def 'v_Dashboard_User_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U54e2df33')
def 'v_Dashboard_User_Page: e_Access_Edit_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Edit_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user/10/edit' and contains(@class, 'bg-black mr-2 text-white rounded-md px-2 py-1 m-2')]")));
	Edit_User_Element.click();
}


@TRIGGER('U4bbb002e')
def 'v_Dashboard_User_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U47a4c0fc')
def 'v_Dashboard_User_Page: e_Return_Dashboard_User_Page'() {
	if ($VAR.HasDeleteUser == false) {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='bg-red-600 text-white rounded-md px-2 py-1 m-2 transition duration-500 ease select-none hover:bg-red-600 focus:outline-none focus:shadow-outline']")));
		Dashboard_User_Element.click();
		$VAR.HasDeleteUser = true;
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
		Dashboard_User_Element.click();
	}
}


@TRIGGER('U8f280d7e')
def 'v_Dashboard_User_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U6e6196df')
def 'v_Edit_Product_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U24286b8a')
def 'v_Edit_Product_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('Ue5f1d26c')
def 'v_Edit_Product_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U8ed22c18')
def 'v_Edit_Product_Page: e_Return_Dashboard_Product_Page'() {
	name = $SYS.getData('name');
	description = $SYS.getData('description');
	price = $SYS.getData('price');

	$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500' and contains(@id, 'grid-last-name') and contains(@type, 'text')]")).sendKeys(name);

	JavascriptExecutor js = (JavascriptExecutor) $SELENIUM.getWebDriver();
	Actions actions = new Actions($SELENIUM.getWebDriver());
	js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", $SELENIUM.getWebDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

	actions.pause(Duration.ofSeconds(1)).perform();

	WebElement textareaElement = $SELENIUM.getWebDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
	textareaElement.click();

	textareaElement.sendKeys(description);
	textareaElement.click();
	textareaElement.sendKeys(description);

	$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500' and contains(@id, 'grid-last-name') and contains(@type, 'number')]")).sendKeys(price);
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded']")).click();
}


@TRIGGER('U8f21a5c8')
def 'v_Edit_Product_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U8c0a77ea')
def 'v_Edit_Transaction_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('U344f2de9')
def 'v_Edit_Transaction_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('Ub25fe95a')
def 'v_Edit_Transaction_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U72a9ce8e')
def 'v_Edit_Transaction_Page: e_Return_Dashboard_Transaction_Page'() {
	Select dropdown = new Select($SELENIUM.getWebDriver().findElement(By.xpath("//select[@class='appearance-none block w-full bg-slate-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500']")));
	dropdown.selectByValue("SUCCESS");
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded']")).click();
}


@TRIGGER('U774fc5e2')
def 'v_Edit_Transaction_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U5a92f6d1')
def 'v_Edit_User_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U310d73f5')
def 'v_Edit_User_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('Ua7ce6490')
def 'v_Edit_User_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U2c9174c1')
def 'v_Edit_User_Page: e_Return_Dashboard_User_Page'() {
	name = $SYS.getData('name');

	$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500' and contains(@id, 'grid-last-name') and contains(@type, 'text') and contains(@name, 'name')]")).sendKeys(name);
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded']")).click();
}


@TRIGGER('U7c151408')
def 'v_Edit_User_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('Ucf9ae78a')
def 'v_Gallery_Product_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U5d4e4b93')
def 'v_Gallery_Product_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('U5411c103')
def 'v_Gallery_Product_Page: e_Access_Upload_Photos_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Upload_Photos_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product/10/gallery/create' and contains(@class, 'bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded shadow-lg')]")));
	Upload_Photos_Element.click();
}


@TRIGGER('Ub4d41eb0')
def 'v_Gallery_Product_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U5b3a0ebd')
def 'v_Gallery_Product_Page: e_Return_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('U6765b8c4')
def 'v_Gallery_Product_Page: e_Return_Gallery_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Gallery_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='bg-red-600 text-white rounded-md px-2 py-1 m-2 transition duration-500 ease select-none hover:bg-red-600 focus:outline-none focus:shadow-outline']")));
	Gallery_Product_Element.click();
}


@TRIGGER('U518103c4')
def 'v_Gallery_Product_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('Uba54582b')
def 'v_Main_Dashboard_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('Ucb7aaa73')
def 'v_Main_Dashboard_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('U6f8b7bb4')
def 'v_Main_Dashboard_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('U03e176ed')
def 'v_Show_Transaction_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('U6de0486c')
def 'v_Show_Transaction_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('U9e8ebd89')
def 'v_Show_Transaction_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('U585acb8a')
def 'v_Show_Transaction_Page: e_Return_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('Uebfa5536')
def 'v_Show_Transaction_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('Uc7225555')
def 'v_Upload_Photos_Page: e_Access_Dashboard_Product_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Product_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/product' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Product_Element.click();
}


@TRIGGER('Uce7a5eab')
def 'v_Upload_Photos_Page: e_Access_Dashboard_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_Transaction_Element.click();
}


@TRIGGER('Uc93726c6')
def 'v_Upload_Photos_Page: e_Access_Dashboard_User_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_User_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/user' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_User_Element.click();
}


@TRIGGER('U8e98d34a')
def 'v_Upload_Photos_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasAddUser = false;
}


@TRIGGER('Ue0916236')
def 'v_Upload_Photos_Page: e_Return_Gallery_Product_Page'() {
	$SELENIUM.getWebDriver().findElement(By.xpath("//input[@class='appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500']")).sendKeys("C:\\Users\\LENOVO\\Pictures\\aurora-borealis-9h.jpg");
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class=' shadow-lg bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded']")).click();
}


@TRIGGER('U5ce88e2a')
def 'v_Upload_Photos_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('MBT_FAIL')
def 'MBT_FAIL' () {
	$SELENIUM.snapScreen('');
}
