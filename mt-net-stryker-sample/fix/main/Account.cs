using System;

namespace fix.main
{
    public class Account
    {
        private const double MaxOverdraftLimit = 500;

        public Account(string aOwner)
        {
            Id = Guid.NewGuid();
            Owner = aOwner;
        }

        public Guid Id { get; }
        public string Owner { get; }
        public double Balance { get; private set; }
        public bool Overdraft { get; private set; }

        public void EnableOverdraft()
        {
            Overdraft = true;
        }

        public void DisableOverdraft()
        {
            Overdraft = false;
        }

        public void AddMoney(double aAmount)
        {
            Balance += aAmount;
        }

        public void WithdrawMoney(double aAmount)
        {
            if (CanWithdraw(aAmount))
            {
                Balance -= aAmount;
            }
        }

        private bool CanWithdraw(double aAmount)
        {
            return Overdraft ? ((Balance + MaxOverdraftLimit) >= aAmount) : (Balance >= aAmount);
        }
    }
}