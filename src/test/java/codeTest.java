import com.util.validCode.CreateVerificationCode;
import com.util.validCode.CreateVerificationCodeImage;
public class codeTest {
    public static void main(String[] args) {
        String vericode= CreateVerificationCode.getSecurityCode();
        new CreateVerificationCodeImage(vericode).createImage();
        return;
    }
}
