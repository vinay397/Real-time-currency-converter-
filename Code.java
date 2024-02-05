import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
public class CurrencyConverter extends JFrame {
private JComboBox&lt;String&gt; fromCurrency;
private JComboBox&lt;String&gt; toCurrency;
private JTextField amountField;
private JButton convertButton;
private JLabel resultLabel;
private Map&lt;String, Double&gt; rates = new HashMap&lt;&gt;();
private String apiKey = " API KEY "
public CurrencyConverter() {
super(&quot;Currency Converter&quot;);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(400, 200);
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
JPanel fromPanel = new JPanel();
fromCurrency = new JComboBox&lt;&gt;();
fromPanel.add(new JLabel(&quot;From:&quot;));
fromPanel.add(fromCurrency);
JPanel toPanel = new JPanel();
toCurrency = new JComboBox&lt;&gt;();
toPanel.add(new JLabel(&quot;To:&quot;));
toPanel.add(toCurrency);
JPanel amountPanel = new JPanel();
amountField = new JTextField(10);
amountPanel.add(new JLabel(&quot;Amount:&quot;));
amountPanel.add(amountField);
JPanel buttonPanel = new JPanel();
convertButton = new JButton(&quot;Convert&quot;);

buttonPanel.add(convertButton);
resultLabel = new JLabel(&quot;&quot;);
convertButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
double amount = Double.parseDouble(amountField.getText());
String from = fromCurrency.getSelectedItem().toString();
String to = toCurrency.getSelectedItem().toString();
double rateFrom = rates.getOrDefault(from, 1.0);
double rateTo = rates.getOrDefault(to, 1.0);
double result = amount * rateTo / rateFrom;
resultLabel.setText(amount + &quot; &quot; + from + &quot; = &quot; + result + &quot; &quot; + to);
} catch (NumberFormatException ex) {
resultLabel.setText(&quot;Invalid input. Please enter a valid number.&quot;);
}
}
});
panel.add(fromPanel);
panel.add(toPanel);
panel.add(amountPanel);
panel.add(buttonPanel);
panel.add(resultLabel);
add(panel);
manuallyAddCurrencies();
fetchExchangeRates();
}
private void manuallyAddCurrencies() {
// Add currencies
fromCurrency.addItem(&quot;USD&quot;);
fromCurrency.addItem(&quot;EUR&quot;);
fromCurrency.addItem(&quot;INR&quot;);
// ...
toCurrency.addItem(&quot;USD&quot;);
toCurrency.addItem(&quot;EUR&quot;);
toCurrency.addItem(&quot;INR&quot;);
// ...
}

private void fetchExchangeRates() {
// API call to get rates
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -&gt; {
new CurrencyConverter().setVisible(true);
});
}
}
