package appinventor.ai_bahyyazid.LED_Flashlight;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.Slider;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.StopBlocksExecution;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.appinventor.components.runtime.util.ScreenDensityUtil;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

/* compiled from: Screen1.yail */
public class Screen1 extends Form implements Runnable {
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Screen1").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("CloseScreenAnimation").readResolve());
    static final SimpleSymbol Lit100 = ((SimpleSymbol) new SimpleSymbol("Connect").readResolve());
    static final SimpleSymbol Lit101 = ((SimpleSymbol) new SimpleSymbol("Selection").readResolve());
    static final PairWithPosition Lit102 = PairWithPosition.make(Lit7, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 639096);
    static final SimpleSymbol Lit103 = ((SimpleSymbol) new SimpleSymbol("ListPicker1$AfterPicking").readResolve());
    static final SimpleSymbol Lit104 = ((SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve());
    static final FString Lit105 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit106 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement19").readResolve());
    static final IntNum Lit107 = IntNum.make(16777215);
    static final IntNum Lit108 = IntNum.make(-1013);
    static final FString Lit109 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("Icon").readResolve());
    static final FString Lit110 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit111 = ((SimpleSymbol) new SimpleSymbol("Button4").readResolve());
    static final IntNum Lit112 = IntNum.make(-1013);
    static final IntNum Lit113 = IntNum.make(-1027);
    static final FString Lit114 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit115 = ((SimpleSymbol) new SimpleSymbol("Clock1").readResolve());
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("TimerEnabled").readResolve());
    static final SimpleSymbol Lit117 = ((SimpleSymbol) new SimpleSymbol("Button4$TouchDown").readResolve());
    static final SimpleSymbol Lit118 = ((SimpleSymbol) new SimpleSymbol("TouchDown").readResolve());
    static final SimpleSymbol Lit119 = ((SimpleSymbol) new SimpleSymbol("Button4$TouchUp").readResolve());
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit120 = ((SimpleSymbol) new SimpleSymbol("TouchUp").readResolve());
    static final FString Lit121 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit122 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement18").readResolve());
    static final IntNum Lit123 = IntNum.make(16777215);
    static final IntNum Lit124 = IntNum.make(-1027);
    static final FString Lit125 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit126 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit127 = ((SimpleSymbol) new SimpleSymbol("Button5").readResolve());
    static final IntNum Lit128 = IntNum.make(-1013);
    static final IntNum Lit129 = IntNum.make(-1027);
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("Scrollable").readResolve());
    static final FString Lit130 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit131 = PairWithPosition.make(Lit7, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 835666);
    static final SimpleSymbol Lit132 = ((SimpleSymbol) new SimpleSymbol("Button5$Click").readResolve());
    static final FString Lit133 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit134 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement23").readResolve());
    static final IntNum Lit135 = IntNum.make(16777215);
    static final IntNum Lit136 = IntNum.make(-1013);
    static final IntNum Lit137 = IntNum.make((int) ScreenDensityUtil.DEFAULT_NORMAL_SHORT_DIMENSION);
    static final FString Lit138 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit139 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit14 = ((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve());
    static final SimpleSymbol Lit140 = ((SimpleSymbol) new SimpleSymbol("Button6").readResolve());
    static final IntNum Lit141 = IntNum.make(-1013);
    static final IntNum Lit142 = IntNum.make(-1027);
    static final FString Lit143 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit144 = PairWithPosition.make(Lit7, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 942162);
    static final SimpleSymbol Lit145 = ((SimpleSymbol) new SimpleSymbol("Button6$Click").readResolve());
    static final FString Lit146 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit147 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement24").readResolve());
    static final IntNum Lit148 = IntNum.make(16777215);
    static final IntNum Lit149 = IntNum.make(-1013);
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final FString Lit150 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit151 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit152 = ((SimpleSymbol) new SimpleSymbol("Button7").readResolve());
    static final IntNum Lit153 = IntNum.make(-1013);
    static final IntNum Lit154 = IntNum.make(-1027);
    static final FString Lit155 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit156 = ((SimpleSymbol) new SimpleSymbol("Clock2").readResolve());
    static final SimpleSymbol Lit157 = ((SimpleSymbol) new SimpleSymbol("Button7$TouchDown").readResolve());
    static final SimpleSymbol Lit158 = ((SimpleSymbol) new SimpleSymbol("Button7$TouchUp").readResolve());
    static final FString Lit159 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("ShowStatusBar").readResolve());
    static final SimpleSymbol Lit160 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement20").readResolve());
    static final IntNum Lit161 = IntNum.make(16777215);
    static final IntNum Lit162 = IntNum.make(-1027);
    static final FString Lit163 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit164 = new FString("com.google.appinventor.components.runtime.Slider");
    static final SimpleSymbol Lit165 = ((SimpleSymbol) new SimpleSymbol("Slider1").readResolve());
    static final SimpleSymbol Lit166 = ((SimpleSymbol) new SimpleSymbol("MaxValue").readResolve());
    static final IntNum Lit167 = IntNum.make(0);
    static final SimpleSymbol Lit168 = ((SimpleSymbol) new SimpleSymbol("MinValue").readResolve());
    static final IntNum Lit169 = IntNum.make(275);
    static final SimpleSymbol Lit17 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit170 = ((SimpleSymbol) new SimpleSymbol("Visible").readResolve());
    static final FString Lit171 = new FString("com.google.appinventor.components.runtime.Slider");
    static final SimpleSymbol Lit172 = ((SimpleSymbol) new SimpleSymbol("Slider1$PositionChanged").readResolve());
    static final SimpleSymbol Lit173 = ((SimpleSymbol) new SimpleSymbol("PositionChanged").readResolve());
    static final FString Lit174 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit175 = ((SimpleSymbol) new SimpleSymbol("Button8").readResolve());
    static final IntNum Lit176 = IntNum.make(-1013);
    static final IntNum Lit177 = IntNum.make(-1027);
    static final FString Lit178 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit179;
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit180 = ((SimpleSymbol) new SimpleSymbol("Button8$Click").readResolve());
    static final FString Lit181 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final SimpleSymbol Lit182 = ((SimpleSymbol) new SimpleSymbol("VerticalScrollArrangement1").readResolve());
    static final IntNum Lit183 = IntNum.make(16777215);
    static final FString Lit184 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit185 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit186 = ((SimpleSymbol) new SimpleSymbol("Image2").readResolve());
    static final IntNum Lit187 = IntNum.make(-1010);
    static final IntNum Lit188 = IntNum.make(-1075);
    static final FString Lit189 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve());
    static final FString Lit190 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit191 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit192 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit193 = ((SimpleSymbol) new SimpleSymbol("TimerInterval").readResolve());
    static final IntNum Lit194 = IntNum.make(70);
    static final FString Lit195 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit196 = ((SimpleSymbol) new SimpleSymbol("Clock1$Timer").readResolve());
    static final SimpleSymbol Lit197 = ((SimpleSymbol) new SimpleSymbol("Timer").readResolve());
    static final FString Lit198 = new FString("com.google.appinventor.components.runtime.Clock");
    static final FString Lit199 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final FString Lit20 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit200 = ((SimpleSymbol) new SimpleSymbol("Clock2$Timer").readResolve());
    static final SimpleSymbol Lit201 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit202 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit203 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit204 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit205 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit206 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit207 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit208 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit209 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement1").readResolve());
    static final SimpleSymbol Lit210 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit211 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit212 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit213 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit214 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit22 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit23 = IntNum.make(2);
    static final IntNum Lit24 = IntNum.make(16777215);
    static final FString Lit25 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit26 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit27 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement25").readResolve());
    static final IntNum Lit28 = IntNum.make(16777215);
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit30 = IntNum.make(-1005);
    static final SimpleSymbol Lit31 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit32 = IntNum.make(-1005);
    static final FString Lit33 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit34 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit35 = ((SimpleSymbol) new SimpleSymbol("Image1").readResolve());
    static final IntNum Lit36 = IntNum.make(-1015);
    static final SimpleSymbol Lit37 = ((SimpleSymbol) new SimpleSymbol("Picture").readResolve());
    static final IntNum Lit38 = IntNum.make(-1074);
    static final FString Lit39 = new FString("com.google.appinventor.components.runtime.Image");
    static final IntNum Lit4 = IntNum.make(3);
    static final FString Lit40 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit41 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement5").readResolve());
    static final IntNum Lit42 = IntNum.make(16777215);
    static final IntNum Lit43 = IntNum.make(-1009);
    static final FString Lit44 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit45 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit46 = ((SimpleSymbol) new SimpleSymbol("TextBox1").readResolve());
    static final IntNum Lit47;
    static final SimpleSymbol Lit48 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final DFloNum Lit49 = DFloNum.make((double) 24);
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("number").readResolve());
    static final IntNum Lit50 = IntNum.make(-1007);
    static final SimpleSymbol Lit51 = ((SimpleSymbol) new SimpleSymbol("Hint").readResolve());
    static final SimpleSymbol Lit52 = ((SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve());
    static final IntNum Lit53 = IntNum.make(1);
    static final IntNum Lit54 = IntNum.make(-1080);
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit56 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement7").readResolve());
    static final IntNum Lit58 = IntNum.make(16777215);
    static final IntNum Lit59 = IntNum.make(-1009);
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final FString Lit60 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit61 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit62 = ((SimpleSymbol) new SimpleSymbol("Button1").readResolve());
    static final IntNum Lit63 = IntNum.make(-1007);
    static final SimpleSymbol Lit64 = ((SimpleSymbol) new SimpleSymbol(Component.LISTVIEW_KEY_IMAGE).readResolve());
    static final IntNum Lit65 = IntNum.make(-1038);
    static final FString Lit66 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit67 = ((SimpleSymbol) new SimpleSymbol("BluetoothClient1").readResolve());
    static final SimpleSymbol Lit68 = ((SimpleSymbol) new SimpleSymbol("SendText").readResolve());
    static final SimpleSymbol Lit69 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit7;
    static final PairWithPosition Lit70 = PairWithPosition.make(Lit7, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 442477);
    static final SimpleSymbol Lit71 = ((SimpleSymbol) new SimpleSymbol("Button1$Click").readResolve());
    static final SimpleSymbol Lit72 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit74 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement9").readResolve());
    static final IntNum Lit75 = IntNum.make(16777215);
    static final IntNum Lit76 = IntNum.make(-1004);
    static final FString Lit77 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit79 = ((SimpleSymbol) new SimpleSymbol("Button2").readResolve());
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit80 = IntNum.make(-1007);
    static final IntNum Lit81 = IntNum.make(-1038);
    static final FString Lit82 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit83 = PairWithPosition.make(Lit7, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 532562);
    static final SimpleSymbol Lit84 = ((SimpleSymbol) new SimpleSymbol("Button2$Click").readResolve());
    static final FString Lit85 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit86 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement22").readResolve());
    static final IntNum Lit87 = IntNum.make(16777215);
    static final IntNum Lit88 = IntNum.make(-1009);
    static final FString Lit89 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final IntNum Lit9;
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit91 = ((SimpleSymbol) new SimpleSymbol("ListPicker1").readResolve());
    static final IntNum Lit92 = IntNum.make(-1007);
    static final IntNum Lit93 = IntNum.make(-1080);
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit95 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("AddressesAndNames").readResolve());
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("list").readResolve());
    static final SimpleSymbol Lit98 = ((SimpleSymbol) new SimpleSymbol("ListPicker1$BeforePicking").readResolve());
    static final SimpleSymbol Lit99 = ((SimpleSymbol) new SimpleSymbol("BeforePicking").readResolve());
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn41 = null;
    static final ModuleMethod lambda$Fn42 = null;
    static final ModuleMethod lambda$Fn43 = null;
    static final ModuleMethod lambda$Fn44 = null;
    static final ModuleMethod lambda$Fn45 = null;
    static final ModuleMethod lambda$Fn46 = null;
    static final ModuleMethod lambda$Fn47 = null;
    static final ModuleMethod lambda$Fn48 = null;
    static final ModuleMethod lambda$Fn49 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn50 = null;
    static final ModuleMethod lambda$Fn51 = null;
    static final ModuleMethod lambda$Fn52 = null;
    static final ModuleMethod lambda$Fn53 = null;
    static final ModuleMethod lambda$Fn54 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public BluetoothClient BluetoothClient1;
    public Button Button1;
    public final ModuleMethod Button1$Click;
    public Button Button2;
    public final ModuleMethod Button2$Click;
    public Button Button4;
    public final ModuleMethod Button4$TouchDown;
    public final ModuleMethod Button4$TouchUp;
    public Button Button5;
    public final ModuleMethod Button5$Click;
    public Button Button6;
    public final ModuleMethod Button6$Click;
    public Button Button7;
    public final ModuleMethod Button7$TouchDown;
    public final ModuleMethod Button7$TouchUp;
    public Button Button8;
    public final ModuleMethod Button8$Click;
    public Clock Clock1;
    public final ModuleMethod Clock1$Timer;
    public Clock Clock2;
    public final ModuleMethod Clock2$Timer;
    public HorizontalArrangement HorizontalArrangement18;
    public HorizontalArrangement HorizontalArrangement19;
    public HorizontalArrangement HorizontalArrangement20;
    public HorizontalArrangement HorizontalArrangement22;
    public HorizontalArrangement HorizontalArrangement23;
    public HorizontalArrangement HorizontalArrangement24;
    public HorizontalArrangement HorizontalArrangement25;
    public HorizontalArrangement HorizontalArrangement5;
    public HorizontalArrangement HorizontalArrangement7;
    public HorizontalArrangement HorizontalArrangement9;
    public Image Image1;
    public Image Image2;
    public ListPicker ListPicker1;
    public final ModuleMethod ListPicker1$AfterPicking;
    public final ModuleMethod ListPicker1$BeforePicking;
    public Slider Slider1;
    public final ModuleMethod Slider1$PositionChanged;
    public TextBox TextBox1;
    public VerticalArrangement VerticalArrangement1;
    public VerticalScrollArrangement VerticalScrollArrangement1;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit7 = simpleSymbol;
        Lit179 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1700817381222_0.44885227697582963-0/youngandroidproject/../src/appinventor/ai_bahyyazid/LED_Flashlight/Screen1.yail", 1192018);
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit47 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -16777216;
        Lit9 = IntNum.make(iArr2);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit201, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit202, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit203, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit204, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit205, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit206, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit207, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit208, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit209, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit210, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit211, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit212, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit213, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit214, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime8631272541632802891.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, (Object) null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 21, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 24, (Object) null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 25, (Object) null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 26, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 30, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 31, (Object) null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 33, (Object) null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 34, (Object) null, 0);
        this.Button1$Click = new ModuleMethod(frame2, 35, Lit71, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 36, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 37, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 39, (Object) null, 0);
        this.Button2$Click = new ModuleMethod(frame2, 40, Lit84, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 41, (Object) null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 42, (Object) null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 43, (Object) null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 44, (Object) null, 0);
        this.ListPicker1$BeforePicking = new ModuleMethod(frame2, 45, Lit98, 0);
        this.ListPicker1$AfterPicking = new ModuleMethod(frame2, 46, Lit103, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 47, (Object) null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 48, (Object) null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 49, (Object) null, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 50, (Object) null, 0);
        this.Button4$TouchDown = new ModuleMethod(frame2, 51, Lit117, 0);
        this.Button4$TouchUp = new ModuleMethod(frame2, 52, Lit119, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 53, (Object) null, 0);
        lambda$Fn30 = new ModuleMethod(frame2, 54, (Object) null, 0);
        lambda$Fn31 = new ModuleMethod(frame2, 55, (Object) null, 0);
        lambda$Fn32 = new ModuleMethod(frame2, 56, (Object) null, 0);
        this.Button5$Click = new ModuleMethod(frame2, 57, Lit132, 0);
        lambda$Fn33 = new ModuleMethod(frame2, 58, (Object) null, 0);
        lambda$Fn34 = new ModuleMethod(frame2, 59, (Object) null, 0);
        lambda$Fn35 = new ModuleMethod(frame2, 60, (Object) null, 0);
        lambda$Fn36 = new ModuleMethod(frame2, 61, (Object) null, 0);
        this.Button6$Click = new ModuleMethod(frame2, 62, Lit145, 0);
        lambda$Fn37 = new ModuleMethod(frame2, 63, (Object) null, 0);
        lambda$Fn38 = new ModuleMethod(frame2, 64, (Object) null, 0);
        lambda$Fn39 = new ModuleMethod(frame2, 65, (Object) null, 0);
        lambda$Fn40 = new ModuleMethod(frame2, 66, (Object) null, 0);
        this.Button7$TouchDown = new ModuleMethod(frame2, 67, Lit157, 0);
        this.Button7$TouchUp = new ModuleMethod(frame2, 68, Lit158, 0);
        lambda$Fn41 = new ModuleMethod(frame2, 69, (Object) null, 0);
        lambda$Fn42 = new ModuleMethod(frame2, 70, (Object) null, 0);
        lambda$Fn43 = new ModuleMethod(frame2, 71, (Object) null, 0);
        lambda$Fn44 = new ModuleMethod(frame2, 72, (Object) null, 0);
        this.Slider1$PositionChanged = new ModuleMethod(frame2, 73, Lit172, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn45 = new ModuleMethod(frame2, 74, (Object) null, 0);
        lambda$Fn46 = new ModuleMethod(frame2, 75, (Object) null, 0);
        this.Button8$Click = new ModuleMethod(frame2, 76, Lit180, 0);
        lambda$Fn47 = new ModuleMethod(frame2, 77, (Object) null, 0);
        lambda$Fn48 = new ModuleMethod(frame2, 78, (Object) null, 0);
        lambda$Fn49 = new ModuleMethod(frame2, 79, (Object) null, 0);
        lambda$Fn50 = new ModuleMethod(frame2, 80, (Object) null, 0);
        lambda$Fn51 = new ModuleMethod(frame2, 81, (Object) null, 0);
        lambda$Fn52 = new ModuleMethod(frame2, 82, (Object) null, 0);
        this.Clock1$Timer = new ModuleMethod(frame2, 83, Lit196, 0);
        lambda$Fn53 = new ModuleMethod(frame2, 84, (Object) null, 0);
        lambda$Fn54 = new ModuleMethod(frame2, 85, (Object) null, 0);
        this.Clock2$Timer = new ModuleMethod(frame2, 86, Lit200, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            this.form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
            FString stringAppend = strings.stringAppend(misc.symbol$To$String(Lit0), "-global-vars");
            if (stringAppend == null) {
                obj = null;
            } else {
                obj = stringAppend.toString();
            }
            this.global$Mnvar$Mnenvironment = Environment.make(obj);
            Screen1 = null;
            this.form$Mnname$Mnsymbol = Lit0;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit6, "Multi Function Flashlight", Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "fade", Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit11, "icon.png", Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "portrait", Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Boolean.FALSE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit7);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Screen1", Lit7);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.FALSE, Lit14), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn2));
                }
                this.VerticalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit20, Lit21, lambda$Fn3), $result);
                } else {
                    addToComponents(Lit0, Lit25, Lit21, lambda$Fn4);
                }
                this.HorizontalArrangement25 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit26, Lit27, lambda$Fn5), $result);
                } else {
                    addToComponents(Lit21, Lit33, Lit27, lambda$Fn6);
                }
                this.Image1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit34, Lit35, lambda$Fn7), $result);
                } else {
                    addToComponents(Lit21, Lit39, Lit35, lambda$Fn8);
                }
                this.HorizontalArrangement5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit40, Lit41, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit21, Lit44, Lit41, lambda$Fn10);
                }
                this.TextBox1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit41, Lit45, Lit46, lambda$Fn11), $result);
                } else {
                    addToComponents(Lit41, Lit55, Lit46, lambda$Fn12);
                }
                this.HorizontalArrangement7 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit56, Lit57, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit21, Lit60, Lit57, lambda$Fn14);
                }
                this.Button1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit61, Lit62, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit57, Lit66, Lit62, lambda$Fn16);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit71, this.Button1$Click);
                } else {
                    addToFormEnvironment(Lit71, this.Button1$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button1", "Click");
                } else {
                    addToEvents(Lit62, Lit72);
                }
                this.HorizontalArrangement9 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit73, Lit74, lambda$Fn17), $result);
                } else {
                    addToComponents(Lit57, Lit77, Lit74, lambda$Fn18);
                }
                this.Button2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit78, Lit79, lambda$Fn19), $result);
                } else {
                    addToComponents(Lit57, Lit82, Lit79, lambda$Fn20);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit84, this.Button2$Click);
                } else {
                    addToFormEnvironment(Lit84, this.Button2$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button2", "Click");
                } else {
                    addToEvents(Lit79, Lit72);
                }
                this.HorizontalArrangement22 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit85, Lit86, lambda$Fn21), $result);
                } else {
                    addToComponents(Lit21, Lit89, Lit86, lambda$Fn22);
                }
                this.ListPicker1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit86, Lit90, Lit91, lambda$Fn23), $result);
                } else {
                    addToComponents(Lit86, Lit94, Lit91, lambda$Fn24);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit98, this.ListPicker1$BeforePicking);
                } else {
                    addToFormEnvironment(Lit98, this.ListPicker1$BeforePicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "ListPicker1", "BeforePicking");
                } else {
                    addToEvents(Lit91, Lit99);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit103, this.ListPicker1$AfterPicking);
                } else {
                    addToFormEnvironment(Lit103, this.ListPicker1$AfterPicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "ListPicker1", "AfterPicking");
                } else {
                    addToEvents(Lit91, Lit104);
                }
                this.HorizontalArrangement19 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit105, Lit106, lambda$Fn25), $result);
                } else {
                    addToComponents(Lit21, Lit109, Lit106, lambda$Fn26);
                }
                this.Button4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit106, Lit110, Lit111, lambda$Fn27), $result);
                } else {
                    addToComponents(Lit106, Lit114, Lit111, lambda$Fn28);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit117, this.Button4$TouchDown);
                } else {
                    addToFormEnvironment(Lit117, this.Button4$TouchDown);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button4", "TouchDown");
                } else {
                    addToEvents(Lit111, Lit118);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit119, this.Button4$TouchUp);
                } else {
                    addToFormEnvironment(Lit119, this.Button4$TouchUp);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button4", "TouchUp");
                } else {
                    addToEvents(Lit111, Lit120);
                }
                this.HorizontalArrangement18 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit106, Lit121, Lit122, lambda$Fn29), $result);
                } else {
                    addToComponents(Lit106, Lit125, Lit122, lambda$Fn30);
                }
                this.Button5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit106, Lit126, Lit127, lambda$Fn31), $result);
                } else {
                    addToComponents(Lit106, Lit130, Lit127, lambda$Fn32);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit132, this.Button5$Click);
                } else {
                    addToFormEnvironment(Lit132, this.Button5$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button5", "Click");
                } else {
                    addToEvents(Lit127, Lit72);
                }
                this.HorizontalArrangement23 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit133, Lit134, lambda$Fn33), $result);
                } else {
                    addToComponents(Lit21, Lit138, Lit134, lambda$Fn34);
                }
                this.Button6 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit134, Lit139, Lit140, lambda$Fn35), $result);
                } else {
                    addToComponents(Lit134, Lit143, Lit140, lambda$Fn36);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit145, this.Button6$Click);
                } else {
                    addToFormEnvironment(Lit145, this.Button6$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button6", "Click");
                } else {
                    addToEvents(Lit140, Lit72);
                }
                this.HorizontalArrangement24 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit146, Lit147, lambda$Fn37), $result);
                } else {
                    addToComponents(Lit21, Lit150, Lit147, lambda$Fn38);
                }
                this.Button7 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit147, Lit151, Lit152, lambda$Fn39), $result);
                } else {
                    addToComponents(Lit147, Lit155, Lit152, lambda$Fn40);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit157, this.Button7$TouchDown);
                } else {
                    addToFormEnvironment(Lit157, this.Button7$TouchDown);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button7", "TouchDown");
                } else {
                    addToEvents(Lit152, Lit118);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit158, this.Button7$TouchUp);
                } else {
                    addToFormEnvironment(Lit158, this.Button7$TouchUp);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button7", "TouchUp");
                } else {
                    addToEvents(Lit152, Lit120);
                }
                this.HorizontalArrangement20 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit147, Lit159, Lit160, lambda$Fn41), $result);
                } else {
                    addToComponents(Lit147, Lit163, Lit160, lambda$Fn42);
                }
                this.Slider1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit160, Lit164, Lit165, lambda$Fn43), $result);
                } else {
                    addToComponents(Lit160, Lit171, Lit165, lambda$Fn44);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit172, this.Slider1$PositionChanged);
                } else {
                    addToFormEnvironment(Lit172, this.Slider1$PositionChanged);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Slider1", "PositionChanged");
                } else {
                    addToEvents(Lit165, Lit173);
                }
                this.Button8 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit147, Lit174, Lit175, lambda$Fn45), $result);
                } else {
                    addToComponents(Lit147, Lit178, Lit175, lambda$Fn46);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit180, this.Button8$Click);
                } else {
                    addToFormEnvironment(Lit180, this.Button8$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button8", "Click");
                } else {
                    addToEvents(Lit175, Lit72);
                }
                this.VerticalScrollArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit21, Lit181, Lit182, lambda$Fn47), $result);
                } else {
                    addToComponents(Lit21, Lit184, Lit182, lambda$Fn48);
                }
                this.Image2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit182, Lit185, Lit186, lambda$Fn49), $result);
                } else {
                    addToComponents(Lit182, Lit189, Lit186, lambda$Fn50);
                }
                this.BluetoothClient1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit190, Lit67, Boolean.FALSE), $result);
                } else {
                    addToComponents(Lit0, Lit191, Lit67, Boolean.FALSE);
                }
                this.Clock1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit192, Lit115, lambda$Fn51), $result);
                } else {
                    addToComponents(Lit0, Lit195, Lit115, lambda$Fn52);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit196, this.Clock1$Timer);
                } else {
                    addToFormEnvironment(Lit196, this.Clock1$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Clock1", "Timer");
                } else {
                    addToEvents(Lit115, Lit197);
                }
                this.Clock2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit198, Lit156, lambda$Fn53), $result);
                } else {
                    addToComponents(Lit0, Lit199, Lit156, lambda$Fn54);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit200, this.Clock2$Timer);
                } else {
                    addToFormEnvironment(Lit200, this.Clock2$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Clock2", "Timer");
                } else {
                    addToEvents(Lit156, Lit197);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit6, "Multi Function Flashlight", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, Lit9, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "fade", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit11, "icon.png", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "portrait", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, Boolean.FALSE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Screen1", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit19, Boolean.FALSE, Lit14);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Lit23, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit8, Lit24, Lit5);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, Lit23, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit8, Lit24, Lit5);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit27, Lit8, Lit28, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit29, Lit30, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit31, Lit32, Lit5);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit27, Lit8, Lit28, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit27, Lit29, Lit30, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit27, Lit31, Lit32, Lit5);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit35, Lit29, Lit36, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit37, "Group2.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit31, Lit38, Lit5);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit35, Lit29, Lit36, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit37, "Group2.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit31, Lit38, Lit5);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit41, Lit8, Lit42, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit29, Lit43, Lit5);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit41, Lit8, Lit42, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit29, Lit43, Lit5);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit8, Lit47, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit48, Lit49, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit29, Lit50, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit51, "Send your text here", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit52, Lit53, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit31, Lit54, Lit5);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit8, Lit47, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit48, Lit49, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit29, Lit50, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit51, "Send your text here", Lit7);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit52, Lit53, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit31, Lit54, Lit5);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit8, Lit58, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit29, Lit59, Lit5);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit8, Lit58, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit29, Lit59, Lit5);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit29, Lit63, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit64, "Component4.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit31, Lit65, Lit5);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit29, Lit63, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit64, "Component4.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit31, Lit65, Lit5);
    }

    public Object Button1$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit68, LList.list1(runtime.getProperty$1(Lit46, Lit69)), Lit70);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit8, Lit75, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit31, Lit76, Lit5);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit8, Lit75, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit31, Lit76, Lit5);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit79, Lit29, Lit80, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit79, Lit64, "Componentstop.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit79, Lit31, Lit81, Lit5);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit79, Lit29, Lit80, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit79, Lit64, "Componentstop.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit79, Lit31, Lit81, Lit5);
    }

    public Object Button2$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit68, LList.list1("*"), Lit83);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit86, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit86, Lit8, Lit87, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit86, Lit29, Lit88, Lit5);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit86, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit86, Lit8, Lit87, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit86, Lit29, Lit88, Lit5);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit29, Lit92, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit91, Lit64, "Connect.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit31, Lit93, Lit5);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit91, Lit29, Lit92, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit91, Lit64, "Connect.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit31, Lit93, Lit5);
    }

    public Object ListPicker1$BeforePicking() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit91, Lit64, "Connect.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit91, Lit95, runtime.getProperty$1(Lit67, Lit96), Lit97);
    }

    public Object ListPicker1$AfterPicking() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit100, LList.list1(runtime.getProperty$1(Lit91, Lit101)), Lit102) != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit91, Lit64, "Connecteds.png", Lit7) : Values.empty;
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit106, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit106, Lit8, Lit107, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit106, Lit29, Lit108, Lit5);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit106, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit106, Lit8, Lit107, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit106, Lit29, Lit108, Lit5);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit111, Lit29, Lit112, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit64, "Brightnessplus.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit31, Lit113, Lit5);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit111, Lit29, Lit112, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit111, Lit64, "Brightnessplus.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit111, Lit31, Lit113, Lit5);
    }

    public Object Button4$TouchDown() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit116, Boolean.TRUE, Lit14);
    }

    public Object Button4$TouchUp() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit116, Boolean.FALSE, Lit14);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit122, Lit8, Lit123, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit122, Lit31, Lit124, Lit5);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit122, Lit8, Lit123, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit122, Lit31, Lit124, Lit5);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit127, Lit29, Lit128, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit127, Lit64, "Output.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit127, Lit31, Lit129, Lit5);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit127, Lit29, Lit128, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit127, Lit64, "Output.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit127, Lit31, Lit129, Lit5);
    }

    public Object Button5$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit68, LList.list1(GetNamedPart.CAST_METHOD_NAME), Lit131);
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit134, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit8, Lit135, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit29, Lit136, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit31, Lit137, Lit5);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit134, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit8, Lit135, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit134, Lit29, Lit136, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit134, Lit31, Lit137, Lit5);
    }

    static Object lambda36() {
        runtime.setAndCoerceProperty$Ex(Lit140, Lit29, Lit141, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit140, Lit64, "Mode.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit140, Lit31, Lit142, Lit5);
    }

    static Object lambda37() {
        runtime.setAndCoerceProperty$Ex(Lit140, Lit29, Lit141, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit140, Lit64, "Mode.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit140, Lit31, Lit142, Lit5);
    }

    public Object Button6$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit68, LList.list1("#"), Lit144);
    }

    static Object lambda38() {
        runtime.setAndCoerceProperty$Ex(Lit147, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit8, Lit148, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit29, Lit149, Lit5);
    }

    static Object lambda39() {
        runtime.setAndCoerceProperty$Ex(Lit147, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit8, Lit148, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit29, Lit149, Lit5);
    }

    static Object lambda40() {
        runtime.setAndCoerceProperty$Ex(Lit152, Lit29, Lit153, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit152, Lit64, "Brightnessminus.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit152, Lit31, Lit154, Lit5);
    }

    static Object lambda41() {
        runtime.setAndCoerceProperty$Ex(Lit152, Lit29, Lit153, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit152, Lit64, "Brightnessminus.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit152, Lit31, Lit154, Lit5);
    }

    public Object Button7$TouchDown() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit156, Lit116, Boolean.TRUE, Lit14);
    }

    public Object Button7$TouchUp() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit156, Lit116, Boolean.FALSE, Lit14);
    }

    static Object lambda42() {
        runtime.setAndCoerceProperty$Ex(Lit160, Lit8, Lit161, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit160, Lit31, Lit162, Lit5);
    }

    static Object lambda43() {
        runtime.setAndCoerceProperty$Ex(Lit160, Lit8, Lit161, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit160, Lit31, Lit162, Lit5);
    }

    static Object lambda44() {
        runtime.setAndCoerceProperty$Ex(Lit165, Lit166, Lit167, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit165, Lit168, Lit169, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit165, Lit170, Boolean.FALSE, Lit14);
    }

    static Object lambda45() {
        runtime.setAndCoerceProperty$Ex(Lit165, Lit166, Lit167, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit165, Lit168, Lit169, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit165, Lit170, Boolean.FALSE, Lit14);
    }

    public Object Slider1$PositionChanged(Object $thumbPosition) {
        runtime.sanitizeComponentData($thumbPosition);
        runtime.setThisForm();
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit2, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda46() {
        runtime.setAndCoerceProperty$Ex(Lit175, Lit29, Lit176, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit175, Lit64, "Speed.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit175, Lit31, Lit177, Lit5);
    }

    static Object lambda47() {
        runtime.setAndCoerceProperty$Ex(Lit175, Lit29, Lit176, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit175, Lit64, "Speed.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit175, Lit31, Lit177, Lit5);
    }

    public Object Button8$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit67, Lit68, LList.list1("^"), Lit179);
    }

    static Object lambda48() {
        runtime.setAndCoerceProperty$Ex(Lit182, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit182, Lit8, Lit183, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit182, Lit31, Lit137, Lit5);
    }

    static Object lambda49() {
        runtime.setAndCoerceProperty$Ex(Lit182, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit182, Lit8, Lit183, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit182, Lit31, Lit137, Lit5);
    }

    static Object lambda50() {
        runtime.setAndCoerceProperty$Ex(Lit186, Lit29, Lit187, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit186, Lit37, "Group4.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit186, Lit31, Lit188, Lit5);
    }

    static Object lambda51() {
        runtime.setAndCoerceProperty$Ex(Lit186, Lit29, Lit187, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit186, Lit37, "Group4.png", Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit186, Lit31, Lit188, Lit5);
    }

    /* compiled from: Screen1.yail */
    public class frame extends ModuleBody {
        Screen1 $main;

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 7:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 73:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 8:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 16:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
                case 73:
                    return this.$main.Slider1$PositionChanged(obj);
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            boolean z = true;
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    Screen1 screen1 = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    screen1.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
                default:
                    return super.apply2(moduleMethod, obj, obj2);
            }
        }

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Screen1.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Screen1.lambda3();
                case 21:
                    return Screen1.lambda4();
                case 22:
                    return Screen1.lambda5();
                case 23:
                    return Screen1.lambda6();
                case 24:
                    return Screen1.lambda7();
                case 25:
                    return Screen1.lambda8();
                case 26:
                    return Screen1.lambda9();
                case 27:
                    return Screen1.lambda10();
                case 28:
                    return Screen1.lambda11();
                case 29:
                    return Screen1.lambda12();
                case 30:
                    return Screen1.lambda13();
                case 31:
                    return Screen1.lambda14();
                case 32:
                    return Screen1.lambda15();
                case 33:
                    return Screen1.lambda16();
                case 34:
                    return Screen1.lambda17();
                case 35:
                    return this.$main.Button1$Click();
                case 36:
                    return Screen1.lambda18();
                case 37:
                    return Screen1.lambda19();
                case 38:
                    return Screen1.lambda20();
                case 39:
                    return Screen1.lambda21();
                case 40:
                    return this.$main.Button2$Click();
                case 41:
                    return Screen1.lambda22();
                case 42:
                    return Screen1.lambda23();
                case 43:
                    return Screen1.lambda24();
                case 44:
                    return Screen1.lambda25();
                case 45:
                    return this.$main.ListPicker1$BeforePicking();
                case 46:
                    return this.$main.ListPicker1$AfterPicking();
                case 47:
                    return Screen1.lambda26();
                case 48:
                    return Screen1.lambda27();
                case 49:
                    return Screen1.lambda28();
                case 50:
                    return Screen1.lambda29();
                case 51:
                    return this.$main.Button4$TouchDown();
                case 52:
                    return this.$main.Button4$TouchUp();
                case 53:
                    return Screen1.lambda30();
                case 54:
                    return Screen1.lambda31();
                case 55:
                    return Screen1.lambda32();
                case 56:
                    return Screen1.lambda33();
                case 57:
                    return this.$main.Button5$Click();
                case 58:
                    return Screen1.lambda34();
                case 59:
                    return Screen1.lambda35();
                case 60:
                    return Screen1.lambda36();
                case 61:
                    return Screen1.lambda37();
                case 62:
                    return this.$main.Button6$Click();
                case 63:
                    return Screen1.lambda38();
                case 64:
                    return Screen1.lambda39();
                case 65:
                    return Screen1.lambda40();
                case 66:
                    return Screen1.lambda41();
                case 67:
                    return this.$main.Button7$TouchDown();
                case 68:
                    return this.$main.Button7$TouchUp();
                case 69:
                    return Screen1.lambda42();
                case 70:
                    return Screen1.lambda43();
                case 71:
                    return Screen1.lambda44();
                case 72:
                    return Screen1.lambda45();
                case 74:
                    return Screen1.lambda46();
                case 75:
                    return Screen1.lambda47();
                case 76:
                    return this.$main.Button8$Click();
                case 77:
                    return Screen1.lambda48();
                case 78:
                    return Screen1.lambda49();
                case 79:
                    return Screen1.lambda50();
                case 80:
                    return Screen1.lambda51();
                case 81:
                    return Screen1.lambda52();
                case 82:
                    return Screen1.lambda53();
                case 83:
                    return this.$main.Clock1$Timer();
                case 84:
                    return Screen1.lambda54();
                case 85:
                    return Screen1.lambda55();
                case 86:
                    return this.$main.Clock2$Timer();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 54:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 55:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 61:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 62:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 63:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 64:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 65:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 66:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 67:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 68:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 69:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 70:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 71:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 72:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 74:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 75:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 76:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 77:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 78:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 79:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 80:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 81:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 82:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 83:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 84:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 85:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 86:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    static Object lambda52() {
        runtime.setAndCoerceProperty$Ex(Lit115, Lit116, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit193, Lit194, Lit5);
    }

    static Object lambda53() {
        runtime.setAndCoerceProperty$Ex(Lit115, Lit116, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit115, Lit193, Lit194, Lit5);
    }

    public Object Clock1$Timer() {
        runtime.setThisForm();
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit2, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda54() {
        runtime.setAndCoerceProperty$Ex(Lit156, Lit116, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit156, Lit193, Lit194, Lit5);
    }

    static Object lambda55() {
        runtime.setAndCoerceProperty$Ex(Lit156, Lit116, Boolean.FALSE, Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit156, Lit193, Lit194, Lit5);
    }

    public Object Clock2$Timer() {
        runtime.setThisForm();
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit2, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(true);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        boolean x = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & true;
        if (x) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (!x) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        boolean x;
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (StopBlocksExecution e) {
                return false;
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this == componentObject) {
                    x = true;
                } else {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
                return false;
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
                return false;
            }
        }
    }

    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        Boolean bool;
        boolean x = true;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName)));
        if (handler != Boolean.FALSE) {
            try {
                Apply apply = Scheme.apply;
                if (notAlreadyHandled) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                apply.apply2(handler, lists.cons(componentObject, lists.cons(bool, LList.makeList(args, 0))));
            } catch (StopBlocksExecution e) {
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this != componentObject) {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    public void $define() {
        Object reverse;
        Object obj;
        Object reverse2;
        Object obj2;
        Object obj3;
        Object var;
        Object component$Mnname;
        Object obj4;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        Object obj5 = this.events$Mnto$Mnregister;
        while (obj5 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj5;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj6 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj6, apply12 == null ? null : apply12.toString());
                obj5 = arg0.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, obj5);
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            reverse = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse != LList.Empty) {
                Pair arg02 = (Pair) reverse;
                misc.force(arg02.getCar());
                reverse = arg02.getCdr();
            }
            obj = components;
            while (obj != LList.Empty) {
                Pair arg03 = (Pair) obj;
                Object component$Mninfo = arg03.getCar();
                component$Mnname = lists.caddr.apply1(component$Mninfo);
                lists.cadddr.apply1(component$Mninfo);
                Object component$Mnobject = Invoke.make.apply2(lists.cadr.apply1(component$Mninfo), lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo)));
                SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                obj = arg03.getCdr();
            }
            reverse2 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse2 != LList.Empty) {
                Pair arg04 = (Pair) reverse2;
                Object var$Mnval = arg04.getCar();
                var = lists.car.apply1(var$Mnval);
                addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                reverse2 = arg04.getCdr();
            }
            LList component$Mndescriptors = components;
            obj2 = component$Mndescriptors;
            while (obj2 != LList.Empty) {
                Pair arg05 = (Pair) obj2;
                Object component$Mninfo2 = arg05.getCar();
                lists.caddr.apply1(component$Mninfo2);
                Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                if (init$Mnthunk != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                obj2 = arg05.getCdr();
            }
            obj3 = component$Mndescriptors;
            while (obj3 != LList.Empty) {
                Pair arg06 = (Pair) obj3;
                Object component$Mninfo3 = arg06.getCar();
                Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                lists.cadddr.apply1(component$Mninfo3);
                callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                obj3 = arg06.getCdr();
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "arg0", -2, obj3);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "arg0", -2, obj2);
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "add-to-global-var-environment", 0, var);
        } catch (ClassCastException e5) {
            throw new WrongType(e5, "arg0", -2, reverse2);
        } catch (ClassCastException e6) {
            throw new WrongType(e6, "add-to-form-environment", 0, component$Mnname);
        } catch (ClassCastException e7) {
            throw new WrongType(e7, "lookup-in-form-environment", 0, obj4);
        } catch (ClassCastException e8) {
            throw new WrongType(e8, "arg0", -2, obj);
        } catch (ClassCastException e9) {
            throw new WrongType(e9, "arg0", -2, reverse);
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        LList lList = symbols;
        while (lList != LList.Empty) {
            try {
                Pair arg0 = (Pair) lList;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(misc.symbol$To$String((Symbol) car), obj);
                    lList = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, lList);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
