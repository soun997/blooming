const validFundingTitleCheck = (keyword: string) => {
  return 0 < keyword.length && keyword.length <= 30;
};

const validEmailCheck = (keyword: string) => {
  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return emailRegex.test(keyword);
};

const validDepositCheck = (keyword: string) => {
  const isNumeric = /^[0-9]+$/.test(keyword);
  const hasCorrectLength = keyword.length === 10;
  return isNumeric && hasCorrectLength;
};

export { validFundingTitleCheck, validEmailCheck, validDepositCheck };
