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

const validCompanyRegistrationNumber = (keyword: string) => {
  const numberPattern = /^[0-9]{10}$/; // 0에서 9까지의 숫자로 이루어진 10자리 문자열 패턴
  return numberPattern.test(keyword);
};

const validCompanyName = (keyword: string) => {
  return keyword.length >= 1;
};

const validTargetAmount = (keyword: string) => {
  const numericPart = keyword.replace(/\D/g, '');
  if (keyword.length !== numericPart.length) {
    return false;
  }
  const amount = parseInt(numericPart, 10);
  if (isNaN(amount) || amount < 500000 || amount > 100000000) {
    return false;
  }

  return true;
};

const validIntroduce = (keyword: string) => {
  return keyword.length >= 1;
};

const validTotalAmount = (keyword: string) => {
  const numericPart = keyword.replace(/\D/g, '');
  if (keyword.length !== numericPart.length) {
    return false;
  }

  return true;
};

export {
  validFundingTitleCheck,
  validEmailCheck,
  validDepositCheck,
  validCompanyRegistrationNumber,
  validCompanyName,
  validTargetAmount,
  validIntroduce,
  validTotalAmount,
};
