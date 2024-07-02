import AWS from 'aws-sdk';

// AWS 설정
AWS.config.update({
  accessKeyId: import.meta.env.VITE_IAM_ACCESS_KEY,
  secretAccessKey: import.meta.env.VITE_IAM_SECRET_KEY,
});

// S3 객체 생성
const s3 = new AWS.S3({
  region: import.meta.env.VITE_BUCKET_REGION,
});

// 파일 업로드 함수
const uploadFile = async (file: File, key: string) => {
  const params = {
    Bucket: import.meta.env.VITE_BUCKET_NAME,
    Key: 'blooming/' + key, // S3 버킷 내 경로와 파일명
    Body: file, // 업로드할 파일
    // ACL: 'public-read', // 업로드한 파일에 대한 퍼블릭 액세스 권한
  };

  try {
    const data = await s3.upload(params).promise();
    console.log('파일 업로드 완료:', data.Location);
    return `${import.meta.env.VITE_CDN_URL}/blooming/nft/images/${file.name}`; // 업로드된 파일의 URL 반환
  } catch (error) {
    console.error('파일 업로드 오류:', error);
    throw error;
  }
};

// JSON 업로드 함수
const uploadJson = async (json: object, key: string) => {
  console.log(key);
  const params = {
    Bucket: import.meta.env.VITE_BUCKET_NAME,
    Key: key, // S3 버킷 내 경로와 파일명
    Body: json, // 업로드할 파일
  };

  try {
    const data = await s3.upload(params).promise();
    console.log('파일 업로드 완료:', data.Location);
    return `${import.meta.env.VITE_CDN_URL}/${key}`; // 업로드된 파일의 URL 반환
  } catch (error) {
    console.error('파일 업로드 오류:', error);
    throw error;
  }
};

export default uploadFile;
export { uploadJson };
