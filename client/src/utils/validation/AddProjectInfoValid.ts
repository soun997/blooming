const validCompanyRegistrationNumber = (keyword: string) => {
  const numberPattern = /^[0-9]{10}$/; // 0에서 9까지의 숫자로 이루어진 10자리 문자열 패턴
  return numberPattern.test(keyword);
};

const validCompanyName = (keyword: string) => {
  return keyword.length >= 1;
};

export { validCompanyRegistrationNumber, validCompanyName };
