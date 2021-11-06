using fix.main;

namespace fix.test
{
    public class AccountBuilder
    {
        private double _amount;
        private bool _overdraft;
        private const string Owner = "Mark";

        public Account Build()
        {
            var account = new Account(Owner);

            if (_amount != default)
            {
                account.AddMoney(_amount);
            }

            if (_overdraft != default)
            {
                account.EnableOverdraft();
            }

            return account;
        }

        public AccountBuilder WithOverdraft()
        {
            _overdraft = true;
            return this;
        }

        public AccountBuilder WithInitialAmount(double aValue)
        {
            _amount = aValue;
            return this;
        }
    }
}