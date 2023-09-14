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

export { validCompanyRegistrationNumber, validCompanyName, validTargetAmount };
